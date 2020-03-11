package com.hzl.hadoop.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * description
 * io流操作工具类
 *
 * @author hzl 2020/01/10 2:59 PM
 */
@Slf4j
public class IoUtils {

	private static String basePath = "/Users/hzl/Desktop/";


	/**
	 * 拷贝文件
	 *
	 * @throws IOException
	 */

	public void testCopy() throws IOException {
		File srcFile = new File(basePath + "a.txt");
		File destFile = new File(basePath + "b.txt");
		FileUtils.copyFile(srcFile, destFile);
	}

	/**
	 * 删除文件
	 *
	 * @throws IOException
	 */
	public void testDelete() throws IOException {
		File delFile = new File(basePath + "b.txt");
		FileUtils.forceDelete(delFile);
		//FileUtils.forceMkdir(delFile);
	}

	/**
	 * 比较文件内容
	 *
	 * @throws IOException
	 */
	public void testCompareFile() throws IOException {
		File srcFile = new File(basePath + "a.txt");
		File destFile = new File(basePath + "b.txt");
		boolean result = FileUtils.contentEquals(srcFile, destFile);
		System.out.println(result);
	}

	/**
	 * 移动文件
	 *
	 * @throws IOException
	 */
	public void testMoveFile() throws IOException {
		File srcFile = new File(basePath + "b.txt");
		File destDir = new File(basePath + "move");
		FileUtils.moveToDirectory(srcFile, destDir, true);
	}

	/**
	 * 读取文件内容,只能读取text等文本，word和pdf不可以
	 *
	 * @throws IOException
	 */
	public static void testRead() throws IOException {
		File srcFile = new File(basePath + "Java NIO通信框架在电信领域的实践.docx");
		String content = FileUtils.readFileToString(srcFile, StandardCharsets.UTF_8);
		List<String> contents = FileUtils.readLines(srcFile, StandardCharsets.UTF_8);
		log.info("文件内容" + content);
		log.info("******************");
		for (String string : contents) {
			System.out.println(string);
		}
	}

	/**
	 * 写入文件内容
	 *
	 * @throws IOException
	 */
	public void testWrite() throws IOException {
		File srcFile = new File(basePath + "a.txt");
		FileUtils.writeStringToFile(srcFile, "测试", StandardCharsets.UTF_8, true);
	}

	/**
	 * <p>
	 * 输入流转换字节数组
	 * </p>
	 *
	 * @author hzl 2020/03/09 4:44 PM
	 */
	public static byte[] inputStreamTOByteArray(InputStream inputStream) throws IOException {

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffers = new byte[1024 * 4];
		int n = 0;
		while (-1 != (n = inputStream.read(buffers))) {
			output.write(buffers, 0, n);
		}
		return output.toByteArray();
	}


}
