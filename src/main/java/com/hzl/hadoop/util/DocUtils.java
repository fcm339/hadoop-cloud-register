package com.hzl.hadoop.util;

import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * description
 * 读取word文字内容
 * 参考：https://www.cnblogs.com/estellez/p/4091429.html
 *
 * @author hzl 2020/10/31 10:51 AM
 */
public class DocUtils {

	/**
	 * 读取doc文件内容
	 *
	 * @return 返回文件内容
	 * @throws IOException
	 */
	public static String doc2String(FileInputStream fs) throws IOException {
		StringBuilder result = new StringBuilder();
		try (XWPFDocument doc = new XWPFDocument(fs)) {
			XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
			result.append(extractor.getText());
			POIXMLProperties.CoreProperties coreProps = extractor.getCoreProperties();
			//获取文件基础信息
			printCoreProperties(coreProps);
		}
		return result.toString();
	}

	/**
	 * 通过XWPFDocument对内容进行访问。对于XWPF文档而言，用这种方式进行读操作更佳。
	 * 未测试
	 *
	 * @throws Exception
	 */
	public void testReadByDoc() throws Exception {

		InputStream is = new FileInputStream("D:\\table.docx");
		XWPFDocument doc = new XWPFDocument(is);
		List<XWPFParagraph> paras = doc.getParagraphs();
		for (XWPFParagraph para : paras) {
			//当前段落的属性
//       CTPPr pr = para.getCTP().getPPr();
			System.out.println(para.getText());
		}
		//获取文档中所有的表格
		List<XWPFTable> tables = doc.getTables();
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		for (XWPFTable table : tables) {
			//表格属性
//       CTTblPr pr = table.getCTTbl().getTblPr();
			//获取表格对应的行
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				//获取行对应的单元格
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					System.out.println(cell.getText());
				}
			}
		}
	}

	public static String doc2String(File file) throws IOException {
		return doc2String(new FileInputStream(file));
	}


	/**
	 * 输出CoreProperties信息
	 *
	 * @param coreProps
	 */
	private static void printCoreProperties(POIXMLProperties.CoreProperties coreProps) {
		System.out.println(coreProps.getCategory());   //分类
		System.out.println(coreProps.getCreator()); //创建者
		System.out.println(coreProps.getCreated()); //创建时间
		System.out.println(coreProps.getTitle());   //标题
	}

}
