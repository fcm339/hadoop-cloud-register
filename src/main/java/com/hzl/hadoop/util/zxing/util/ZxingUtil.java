package com.hzl.hadoop.util.zxing.util;


import org.apache.commons.io.IOUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ZxingUtil {
	public static void createFile(byte[] bytes, File file) throws IOException {
		String filePath = file.getCanonicalPath();
		filePath = filePath.replace("\\", "/");
		String directoryPath = filePath.substring(0, filePath.lastIndexOf("/"));
		String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);

		createFile(bytes, directoryPath, fileName);
	}

	public static void createFile(byte[] bytes, String directoryPath, String fileName) throws IOException {
		createDirectory(directoryPath);

		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		try {
			File file = new File(directoryPath + File.separator + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);
		} finally {
			if (bos != null) {
				IOUtils.closeQuietly(bos);
			}
			if (fos != null) {
				IOUtils.closeQuietly(fos);
			}
		}
	}

	public static void createDirectory(File file) throws IOException {
		String filePath = file.getCanonicalPath();
		filePath = filePath.replace("\\", "/");
		String directoryPath = filePath.substring(0, filePath.lastIndexOf("/"));

		createDirectory(directoryPath);
	}

	public static void createDirectory(String directoryPath) {
		File directory = new File(directoryPath);
		if (!directory.exists() || !directory.isDirectory()) {
			directory.mkdirs();
		}
	}
}