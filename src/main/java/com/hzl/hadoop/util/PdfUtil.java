package com.hzl.hadoop.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * pdf文件加水印，二维码，条形码，页码，文件合并
 *
 * @author hzl 2020/01/02 5:27 PM
 */
@Slf4j
public class PdfUtil {
	//字体文件
	public static final String FONTS_PATH = "/fonts/simsun.ttf";

	public static final BaseColor water = new BaseColor(224, 224, 224);

	/**
	 * <p>
	 * streamOfPDFFiles文件地址，
	 * 合并pdf不加页码
	 * </p>
	 *
	 * @author hzl 2020/01/02 5:40 PM
	 */
	public static void concatPDFsNew(List<String> streamOfPDFFiles,
									 OutputStream outputStream) {
		Document document = new Document();
		try {
			List<String> pdfs = streamOfPDFFiles;
			List<PdfReader> readers = new ArrayList<PdfReader>();
			int totalPages = 0;
			Iterator<String> iteratorPDFs = pdfs.iterator();

			String pdf = null;
			PdfReader pdfReader = null;
			while (iteratorPDFs.hasNext()) {
				pdf = iteratorPDFs.next();
				if (null != pdf) {
					pdfReader = new PdfReader(pdf);

					if (null != pdfReader) {
						readers.add(pdfReader);
						totalPages += pdfReader.getNumberOfPages();
					}
				}
			}
			// Create a writer for the outputstream
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();
			BaseFont bf = BaseFont.createFont(FONTS_PATH,
					"Identity-H", true);
			PdfContentByte cb = writer.getDirectContent();

			PdfImportedPage page;
			int currentPageNumber = 0;
			int pageOfCurrentReaderPDF = 0;
			Iterator<PdfReader> iteratorPDFReader = readers.iterator();

			while (iteratorPDFReader.hasNext()) {
				pdfReader = iteratorPDFReader.next();

				if (null != pdfReader) {
					while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
						document.setPageSize(pdfReader.getPageSize(pageOfCurrentReaderPDF + 1));
						document.newPage();
						pageOfCurrentReaderPDF++;
						currentPageNumber++;

						page = writer.getImportedPage(pdfReader,
								pageOfCurrentReaderPDF);

						cb.addTemplate(page, 0, 0);
					}
				}
				pageOfCurrentReaderPDF = 0;
			}
			outputStream.flush();
			if (document.isOpen()) {
				document.close();
			}
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document.isOpen()) {
				document.close();
			}
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	/**
	 * <p>
	 * 合并pdf并添加页码，如果文件地址集合长度为1，则只给文件加页码不合并
	 * streamOfPDFFiles文件地址
	 * paginate 是否添加页码
	 * </p>
	 *
	 * @author hzl 2020/01/02 5:59 PM
	 */
	public static void concatPDFsAndAddPage(List<String> streamOfPDFFiles,
											OutputStream outputStream, boolean paginate) {
		Document document = new Document();
		try {
			List<String> pdfs = streamOfPDFFiles;
			List<PdfReader> readers = new ArrayList<PdfReader>();
			int totalPages = 0;
			Iterator<String> iteratorPDFs = pdfs.iterator();
			Rectangle rectangle = PageSize.A4;
			// Create Readers for the pdfs.
			String pdf = null;
			PdfReader pdfReader = null;
			while (iteratorPDFs.hasNext()) {
				pdf = iteratorPDFs.next();
				if (null != pdf) {
					pdfReader = new PdfReader(pdf);
					rectangle = pdfReader.getPageSize(1);

					if (null != pdfReader) {
						readers.add(pdfReader);
						totalPages += pdfReader.getNumberOfPages();
					}
				}
			}
			// Create a writer for the outputstream
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();
			log.info("文件大小" + rectangle);
			document.setPageSize(rectangle);
			BaseFont bf = BaseFont.createFont(FONTS_PATH,
					"Identity-H", true);
			PdfContentByte cb = writer.getDirectContent(); // Holds the PDF
			// data

			PdfImportedPage page;
			int currentPageNumber = 0;
			int pageOfCurrentReaderPDF = 0;
			Iterator<PdfReader> iteratorPDFReader = readers.iterator();

			while (iteratorPDFReader.hasNext()) {
				pdfReader = iteratorPDFReader.next();
				// Create a new page in the target for each source page.
				if (null != pdfReader) {
					while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
						log.info("文件大小" + pdfReader.getPageSize(pageOfCurrentReaderPDF + 1));
						document.setPageSize(pdfReader.getPageSize(pageOfCurrentReaderPDF + 1));
						document.newPage();
						pageOfCurrentReaderPDF++;
						currentPageNumber++;
						page = writer.getImportedPage(pdfReader,
								pageOfCurrentReaderPDF);
						cb.addTemplate(page, 0, 0);

						// Code for pagination.
						if (paginate) {
							cb.beginText();
							cb.setFontAndSize(bf, 9);
							cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
											+ "第 " + currentPageNumber + " 页，共 " + totalPages + " 页", 520,
									5, 0);
							cb.endText();
						}
					}
				}
				pageOfCurrentReaderPDF = 0;
			}
			outputStream.flush();
			if (document.isOpen()) {
				document.close();
			}
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document.isOpen()) {
				document.close();
			}
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	/**
	 * 添加水印二维码方法
	 *
	 * @param put        输入流
	 * @param out        输出流
	 * @param textMark   水印内容
	 * @param textWidth  水印x
	 * @param textHeight 水印y
	 * @param textHeight 二维码内容
	 *                   contractNumber插入的文字内容
	 */
	public static void addPdfTextMark(InputStream put, OutputStream out, String textMark, int textWidth, int textHeight,
									  String codeStr, String contractNumber) throws Exception {

		PdfReader reader = new PdfReader(put, "PDF".getBytes());
		PdfStamper stamp = new PdfStamper(reader, out);
		// 加二维码
		if (!StringUtils.isBlank(codeStr)) {
			addCode(codeStr, stamp);
		}

		if (StringUtils.isNotBlank(contractNumber)) {
			addContent(reader, stamp, contractNumber);
		}
		PdfContentByte under;

		BaseFont font = BaseFont.createFont(FONTS_PATH, "Identity-H", true);// 使用系统字体


		// 加二维码结束
		// 添加水印
		if (!StringUtils.isBlank(textMark)) {

			PdfGState gs = new PdfGState();
			// gs.setFillOpacity(0.2f);
			// 设置笔触字体不透明度为0.4f
			gs.setStrokeOpacity(0.4f);
			// 原pdf文件的总页数
			int pageSize = reader.getNumberOfPages();


			for (int i = 1; i <= pageSize; i++) {


				// 水印在文本下
				under = stamp.getUnderContent(i);
				//水印在文本上
				// under = stamp.getOverContent(i);
				under.beginText();
				// 文字水印 颜色
				under.setColorFill(water);
				// 文字水印 字体及字号
				under.setFontAndSize(font, 16);
				// 文字水印 起始位置
				under.setTextMatrix(textWidth, textHeight);
				Rectangle pageSize1 = reader.getPageSize(1);
				float height = pageSize1.getHeight();
				float width = pageSize1.getWidth();
				// 设置透明度
				under.setGState(gs);
				for (int l = 1; l <= 3; ++l) {
					float x = 0f;
					switch (l) {
						case 1:
							x = 50;
							break;
						case 2:
							x = width / 2;
							break;
						case 3:
							x = width - 100;
							break;
					}
					for (int sect = 1; sect <= 3; ++sect) {
						float y = 0;
						switch (sect) {
							case 1:
								y = 0;
								break;
							case 2:
								y = height / 2;
								break;
							case 3:
								y = height - 100;
								break;
						}

						under.showTextAligned(Element.ALIGN_LEFT, textMark, x, y, 40);

					}
				}
				// 添加水印结束
				under.endText();
			}
		}

		stamp.close();// 关闭
		reader.close();
	}

	/**
	 * <p>
	 * 文件添加二维码工具类
	 * </p>
	 *
	 * @author hzl 2020/01/02 6:10 PM
	 */
	public static void addCode(String codeStr, PdfStamper stamper) {
		try {
			PdfContentByte waterMar;

			PdfGState gs = new PdfGState();
			long startTime = System.currentTimeMillis();
			log.info("PDF加二维码 start" + codeStr);

			// content = stamper.getOverContent(i);// 在内容上方加水印
			waterMar = stamper.getOverContent(1);// 在内容下方加水印
			waterMar.setColorFill(BaseColor.BLACK);
			// 开始水印处理
			waterMar.beginText();
			// 设置透明度
			waterMar.setGState(gs);

			// 创建水印图片
			com.itextpdf.text.Image itextimage = Image.getInstance((addQRCode(codeStr)).toByteArray());

			// 水印图片位置
			itextimage.setAbsolutePosition(480, 770);
			// 边框固定
			itextimage.scaleToFit(60, 60);
			// 设置旋转弧度
			// image.setRotation(30);// 旋转 弧度
			// 设置旋转角度
			// image.setRotationDegrees(45);// 旋转 角度
			// 设置等比缩放
			itextimage.scalePercent(30);
			// 自定义大小
			itextimage.scaleAbsolute(60, 60);
			// 附件加上水印图片
			waterMar.addImage(itextimage);

			// 完成水印添加
			waterMar.endText();
			// stroke
			waterMar.stroke();

			long endTime = System.currentTimeMillis();
			log.info("PDF加二维码 ok 所用时间:" + (endTime - startTime) + "s");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 生成二维码图片
	 *
	 * @param codeStr 二维码内容
	 */
	private static ByteArrayOutputStream addQRCode(String codeStr) {

		try {
			Hashtable<EncodeHintType, String> hints = new Hashtable();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			int codeWeight = 100;
			int codeHeight = 100;
			BitMatrix bitMatrix = (new MultiFormatWriter()).encode(codeStr, BarcodeFormat.QR_CODE, codeWeight,
					codeHeight, hints);
			BufferedImage localBufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
			ByteArrayOutputStream ios = new ByteArrayOutputStream();
			ImageIO.write(localBufferedImage, "png", ios);
			return ios;
		} catch (Exception var10) {
			throw new RuntimeException("error.add.QR_Code");
		}

	}


	/**
	 * <p>
	 * 向pdf中插入文字
	 * </p>
	 *
	 * @author hzl 2020/01/02 6:20 PM
	 */
	public static void addContent(PdfReader reader, PdfStamper stamper, String contractNumber) throws IOException, DocumentException {

		BaseFont baseFont1 = BaseFont.createFont(FONTS_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(baseFont1);


		for (int i = 1; i <= 1; i++) {
			PdfContentByte over = stamper.getOverContent(i);
			ColumnText columnText = new ColumnText(over);
			// llx 和 urx  最小的值决定离左边的距离. lly 和 ury 最大的值决定离下边的距离
			columnText.setSimpleColumn(600, 750, 400, 750);
			Paragraph elements = new Paragraph(0, new Chunk("合同编号:" + contractNumber));
			// 设置字体，如果不设置添加的中文将无法显示
			elements.setFont(font);
			columnText.addElement(elements);
			columnText.go();
		}
		//stamper.close();
	}

	/**
	 * <p>
	 * 获取pdf文字内容
	 * </p>
	 *
	 * @author hzl 2020/01/10 2:41 PM
	 */
	public static String getPdfFileStr(byte[] bytes){
		// 存放读取出的文档内容
		String content = "";
		try {
			// 读取pdf所使用的输出流
			PdfReader reader = new PdfReader(bytes);
			// 获得页数
			int PageNum = reader.getNumberOfPages();

			for (int i = 1; i <= PageNum; i++) {
				// 读取第i页的文档内容
				content += PdfTextExtractor.getTextFromPage(reader, i);
			}
		} catch (IOException e) {
			log.info("错误：" + e.getMessage());
			e.printStackTrace();
		}

		return content;

	}
}
