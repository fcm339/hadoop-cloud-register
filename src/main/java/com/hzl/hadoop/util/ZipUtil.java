package com.hzl.hadoop.util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;

/**
 * description
 * zip压缩解压工具类,可以使用但是压缩的不给力
 * tar压缩和没有压缩一个样
 * gzip和zip一个样
 * @author hzl 2020/01/17 10:19 PM
 */
public class ZipUtil {

	/**
	 * 使用GBK编码可以避免压缩中文文件名乱码
	 */
	private static final String CHINESE_CHARSET = "GBK";

	/**
	 * 文件读取缓冲区大小
	 */
	private static final int CACHE_SIZE = 1024;

	/**
	 * <p>
	 * 压缩文件
	 * </p>
	 *
	 * @param sourceFolder 压缩文件夹
	 * @param zipFilePath  压缩文件输出路径
	 * @throws Exception
	 */
	public static void zip(String sourceFolder, String zipFilePath)
			throws Exception {
		OutputStream out = new FileOutputStream(zipFilePath);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		ZipOutputStream zos = new ZipOutputStream(bos);
		// 解决中文文件名乱码
		zos.setEncoding(CHINESE_CHARSET);
		File file = new File(sourceFolder);
		String basePath = "";
		if (file.isDirectory()) {
			basePath = file.getPath();
			System.out.println("文件夹 basePath：" + basePath);
		} else {
			basePath = file.getParent().substring(0,
					file.getParent().length() - 1);
			System.out.println("文件 basePath：" + basePath);
		}
		zipFile(file, basePath, zos);
		zos.closeEntry();
		zos.close();
		bos.close();
		out.close();
	}

	/**
	 * <p>
	 * 递归压缩文件
	 * </p>
	 *
	 * @param parentFile
	 * @param basePath
	 * @param zos
	 * @throws Exception
	 */
	private static void zipFile(File parentFile, String basePath,
								ZipOutputStream zos) throws Exception {
		File[] files = new File[0];
		if (parentFile.isDirectory()) {
			files = parentFile.listFiles();
		} else {
			files = new File[1];
			files[0] = parentFile;
		}
		String pathName = "";
		InputStream is = null;
		BufferedInputStream bis = null;
		byte[] cache = new byte[CACHE_SIZE];
		for (File file : files) {
			if (file.isDirectory()) {
				pathName = file.getPath().substring(basePath.length() + 1)
						+ "/";
				System.out.println("---------------1.文件夹pathName:" + pathName);
				zos.putNextEntry(new ZipEntry(pathName));
				zipFile(file, basePath, zos);
			} else {
				pathName = file.getPath().substring(basePath.length() + 1);
				System.out.println("----------------2.文件pathName:" + pathName);
				is = new FileInputStream(file);
				bis = new BufferedInputStream(is);
				zos.putNextEntry(new ZipEntry(pathName));
				int nRead = 0;
				while ((nRead = bis.read(cache, 0, CACHE_SIZE)) != -1) {
					zos.write(cache, 0, nRead);
				}
				bis.close();
				is.close();
			}
		}
	}

	/**
	 * <p>
	 * 解压压缩包
	 * </p>
	 *
	 * @param zipFilePath 压缩文件路径
	 * @param destDir     压缩包释放目录
	 * @throws Exception
	 */
	public static void unZip(String zipFilePath, String destDir)
			throws Exception {
		ZipFile zipFile = new ZipFile(zipFilePath, CHINESE_CHARSET);
		Enumeration<?> emu = zipFile.getEntries();
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		File file = null;
		File parentFile = null;
		ZipEntry entry = null;
		byte[] cache = new byte[CACHE_SIZE];
		while (emu.hasMoreElements()) {
			entry = (ZipEntry) emu.nextElement();
			if (entry.isDirectory()) {
				new File(destDir, entry.getName()).mkdirs();
				continue;
			}
			bis = new BufferedInputStream(zipFile.getInputStream(entry));
			file = new File(destDir, entry.getName());
			parentFile = file.getParentFile();
			if (parentFile != null && (!parentFile.exists())) {
				parentFile.mkdirs();
			}
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos, CACHE_SIZE);
			int nRead = 0;
			while ((nRead = bis.read(cache, 0, CACHE_SIZE)) != -1) {
				fos.write(cache, 0, nRead);
			}
			bos.flush();
			bos.close();
			fos.close();
			bis.close();
		}
		zipFile.close();
	}


	/**
	 * tar打包压缩
	 *
	 * @param filesPathArray 要压缩的文件的全路径(数组)
	 * @param resultFilePath 压缩后的文件全文件名(.tar)
	 * @throws Exception
	 * @DATE 2018年9月25日 下午12:39:28
	 */
	public static boolean tarCompression(String[] filesPathArray, String resultFilePath) throws Exception {
		System.out.println(" tarCompression -> Compression start!");
		FileOutputStream fos = null;
		TarArchiveOutputStream taos = null;
		try {
			fos = new FileOutputStream(new File(resultFilePath));
			taos = new TarArchiveOutputStream(fos);
			for (String filePath : filesPathArray) {
				BufferedInputStream bis = null;
				FileInputStream fis = null;
				try {
					File file = new File(filePath);
					TarArchiveEntry tae = new TarArchiveEntry(file);
					// 此处指明 每一个被压缩文件的名字,以便于解压时TarArchiveEntry的getName()方法获取到的直接就是这里指定的文件名
					// 以(左边的)GBK编码将file.getName()“打碎”为序列,再“组装”序列为(右边的)GBK编码的字符串
					tae.setName(new String(file.getName().getBytes("GBK"), "GBK"));
					taos.putArchiveEntry(tae);
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					int count;
					byte data[] = new byte[1024];
					while ((count = bis.read(data, 0, 1024)) != -1) {
						taos.write(data, 0, count);
					}
				} finally {
					taos.closeArchiveEntry();
					if (bis != null) {
						bis.close();
					}

					if (fis != null) {
						fis.close();
					}
				}
			}
		} finally {
			if (taos != null) {
				taos.close();
			}
			if (fos != null) {
				fos.close();
			}

		}
		System.out.println(" tarCompression -> Compression end!");
		return true;
	}

	/**
	 * tar拆包解压
	 *
	 * @param decompressFilePath 要被解压的压缩文件 全路径
	 * @param resultDirPath      解压文件存放绝对路径(目录)
	 * @throws Exception
	 * @DATE 2018年9月25日 下午12:39:43
	 */
	public static boolean tarDecompression(String decompressFilePath, String resultDirPath) throws Exception {
		System.out.println(" tarDecompression -> Decompression start!");
		TarArchiveInputStream tais = null;
		FileInputStream fis = null;
		try {
			File file = new File(decompressFilePath);
			fis = new FileInputStream(file);
			tais = new TarArchiveInputStream(fis);
			TarArchiveEntry tae = null;
			while ((tae = tais.getNextTarEntry()) != null) {
				BufferedOutputStream bos = null;
				FileOutputStream fos = null;
				try {
					System.out.println("  already decompression file -> " + tae.getName());
					String dir = resultDirPath + File.separator + tae.getName();// tar档中文件
					File dirFile = new File(dir);
					fos = new FileOutputStream(dirFile);
					bos = new BufferedOutputStream(fos);
					int count;
					byte[] data = new byte[1024];
					while ((count = tais.read(data, 0, 1024)) != -1) {
						bos.write(data, 0, count);
					}
				} finally {
					if (bos != null) {
						bos.close();
					}
					if (fos != null) {
						fos.close();
					}
				}
			}
		} finally {
			if (tais != null) {
				tais.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		System.out.println(" tarDecompression -> Decompression end!");
		return true;
	}

	/**
	 * 对.tar文件进行gzip压缩
	 * 说明:我们一般先把多个文件tar打包为一个,然后再使用gzip进行压缩; 进而获得形如“abc.tar.gz”这样的压缩文件
	 * 注:这里暂时不再深入学习,以后有闲暇时间可深入了解如何压缩多个文件等
	 * 注:如果明确知道解压后的是什么类型的文件;那么可以直接指定解压后的文件类型(实际上也需要这么做);
	 * .tar.gz 解压后就是.tar文件,所以我们在解压时,给出的解压后的文件的全路径名就是以.tar结尾的
	 *
	 * @param filePath       要被压缩的压缩文件 全路径
	 * @param resultFilePath 压缩后的文件(全文件名 .gz)
	 * @throws IOException
	 * @DATE 2018年9月25日 下午2:50:22
	 */
	public static boolean gzipCompression(String filePath, String resultFilePath) throws IOException {
		System.out.println(" gzipCompression -> Compression start!");
		InputStream fin = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		GzipCompressorOutputStream gcos = null;
		try {
			fin = Files.newInputStream(Paths.get(filePath));
			bis = new BufferedInputStream(fin);
			fos = new FileOutputStream(resultFilePath);
			bos = new BufferedOutputStream(fos);
			gcos = new GzipCompressorOutputStream(bos);
			byte[] buffer = new byte[1024];
			int read = -1;
			while ((read = bis.read(buffer)) != -1) {
				gcos.write(buffer, 0, read);
			}
		} finally {
			if (gcos != null) {
				gcos.close();
			}
			if (bos != null) {
				bos.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (bis != null) {
				bis.close();
			}
			if (fin != null) {
				fin.close();
			}
		}
		System.out.println(" gzipCompression -> Compression end!");
		return true;
	}

	/**
	 * 解压对.tar.gz文件至 .tar文件
	 * 说明:我们一般都是对.tar.gz文件进行gzip解压; 进而获得形如.tar文件;再进行解压
	 * 注:这里暂时不再深入学习,以后有闲暇时间可深入了解学习
	 *
	 * @param compressedFilePath 要被解压的压缩文件 全路径
	 * @param resultDirPath      解压文件存放绝对路径(目录)
	 * @throws IOException
	 * @DATE 2018年9月25日 下午4:35:09
	 */
	public static boolean gzipDecompression(String compressedFilePath, String resultDirPath) throws IOException {
		System.out.println(" gzipDecompression -> Compression start!");
		InputStream fin = null;
		BufferedInputStream in = null;
		OutputStream out = null;
		GzipCompressorInputStream gcis = null;
		try {
			out = Files.newOutputStream(Paths.get(resultDirPath));
			fin = Files.newInputStream(Paths.get(compressedFilePath));
			in = new BufferedInputStream(fin);
			gcis = new GzipCompressorInputStream(in);
			final byte[] buffer = new byte[1024];
			int n = 0;
			while (-1 != (n = gcis.read(buffer))) {
				out.write(buffer, 0, n);
			}
		} finally {
			if (gcis != null) {
				gcis.close();
			}
			if (in != null) {
				in.close();
			}
			if (fin != null) {
				fin.close();
			}
			if (out != null) {
				out.close();
			}
		}
		System.out.println(" gzipDecompression -> Compression end!");
		return true;
	}


	/**
	 * zip压缩(注:与tar类似)
	 *
	 * @param filesPathArray 要压缩的文件的全路径(数组)
	 * @param resultFilePath 压缩后的文件全文件名(.tar)
	 * @throws Exception
	 * @DATE 2018年9月25日 下午17:55:28
	 */
	public static boolean zipCompression(String[] filesPathArray, String resultFilePath) throws Exception {
		System.out.println(" zipCompression -> Compression start!");
		ZipArchiveOutputStream zaos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(resultFilePath));
			zaos = new ZipArchiveOutputStream(fos);
			for (String filePath : filesPathArray) {
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					File file = new File(filePath);
					// 第二个参数如果是文件全路径名,那么压缩时也会将路径文件夹也缩进去;
					// 我们之压缩目标文件,而不压缩该文件所处位置的相关文件夹,所以这里我们用file.getName()
					ZipArchiveEntry zae = new ZipArchiveEntry(file, file.getName());
					zaos.putArchiveEntry(zae);
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					int count;
					byte data[] = new byte[1024];
					while ((count = bis.read(data, 0, 1024)) != -1) {
						zaos.write(data, 0, count);
					}
				} finally {
					zaos.closeArchiveEntry();
					if (bis != null) {
						bis.close();
					}
					if (fis != null) {
						fis.close();
					}
				}

			}
		} finally {
			if (zaos != null) {
				zaos.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
		System.out.println(" zipCompression -> Compression end!");
		return true;
	}

	/**
	 * zip解压(注:与tar类似)
	 *
	 * @param decompressFilePath 要被解压的压缩文件 全路径
	 * @param resultDirPath      解压文件存放绝对路径(目录)
	 * @throws Exception
	 * @DATE 2018年9月25日 下午18:39:43
	 */
	public static boolean zipDecompression(String decompressFilePath, String resultDirPath) throws Exception {
		System.out.println(" zipDecompression -> Decompression start!");
		ZipArchiveInputStream zais = null;
		FileInputStream fis = null;
		try {
			File file = new File(decompressFilePath);
			fis = new FileInputStream(file);
			zais = new ZipArchiveInputStream(fis);
			ZipArchiveEntry zae = null;
			while ((zae = zais.getNextZipEntry()) != null) {
				FileOutputStream fos = null;
				BufferedOutputStream bos = null;
				try {
					System.out.println("  already decompression file -> " + zae.getName());
					String dir = resultDirPath + File.separator + zae.getName();// tar档中文件
					File dirFile = new File(dir);
					fos = new FileOutputStream(dirFile);
					bos = new BufferedOutputStream(fos);
					int count;
					byte data[] = new byte[1024];
					while ((count = zais.read(data, 0, 1024)) != -1) {
						bos.write(data, 0, count);
					}
				} finally {
					if (bos != null) {
						bos.close();
					}
					if (fos != null) {
						fos.close();
					}
				}
			}
		} finally {
			if (zais != null) {
				zais.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		System.out.println(" zipDecompression -> Decompression end!");
		return true;
	}


}
