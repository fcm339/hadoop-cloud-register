package com.hzl.hadoop.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.hzl.hadoop.util.zxing.core.ZxingDecoder;
import com.hzl.hadoop.util.zxing.core.ZxingEncoder;
import com.hzl.hadoop.util.zxing.entity.ZxingEntity;
import com.hzl.hadoop.util.zxing.util.ZxingUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * description
 * 二维码和条形码工具类
 * 	参考https://github.com/Nepxion/Zxing
 * @author hzl 2020/01/03 5:53 PM
 */
@Slf4j
public class Zxing {

	/**
	 * 相关参数说明
	 * text              二维码/条形码内容。二维码可以是文字，也可以是URL，条形码必须是数字
	 * format            二维码/条形码图片格式，例如jpg，png
	 * encoding          二维码/条形码内容编码，例如UTF-8
	 * correctionLevel   二维码/条形码容错等级，例如ErrorCorrectionLevel.H(30%纠正率)，ErrorCorrectionLevel.Q(25%纠正率)，ErrorCorrectionLevel.M(15%纠正率)，ErrorCorrectionLevel.L(7%纠正率)。纠正率越高，扫描速度越慢
	 * width             二维码/条形码图片宽度
	 * height            二维码/条形码图片高度
	 * margin            二维码/条形码图片白边大小，取值范围0~4
	 * foregroundColor   二维码/条形码图片前景色。格式如0xFF000000
	 * backgroundColor   二维码/条形码图片背景色。格式如0xFFFFFFFF
	 * deleteWhiteBorder 二维码图片白边去除。当图片面积较小时候，可以利用该方法扩大二维码/条形码的显示面积
	 * logoFile          二维码Logo图片的文件，File对象。显示在二维码中间的Logo图片，其在二维码中的尺寸最大为100x100左右，否则会覆盖二维码导致最后不能被识别
	 * outputFile        二维码/条形码图片的导出文件，File对象
	 */

	public static void main(String[] args) throws Exception {
		executeForQRFile();
		// executeForQRBytes();

		//executeForEANFile();
		 executeForEANBytes();
	}

	public static void executeForQRFile() {
		// 二维码内容
		String text = "刻章服务";
		// 二维码图片导出路径
		File file = new File("/Users/hzl/Desktop/二维码.jpg");

		// 二维码参数的构造对象，很多参数赋予了默认值，可自行通过set方法更改
		ZxingEntity entity = new ZxingEntity();
		entity.setBarcodeFormat(BarcodeFormat.QR_CODE);
		entity.setLogoFile(new File("/Users/hzl/Desktop/公章.png"));
		entity.setText(text);
		entity.setOutputFile(file);
		entity.setWidth(430);
		entity.setHeight(430);

		// 以文件格式读取并导出，该方式适合本地调用
		ZxingEncoder encoder = new ZxingEncoder();
		encoder.encodeForFile(entity);

		// 以文件格式扫描并解析
		ZxingDecoder decoder = new ZxingDecoder();
		Result result = decoder.decodeByFile(file, entity.getEncoding());

		log.info("扫描结果 - [Text] : " + result.getText() + " [Timestamp] : " + result.getTimestamp() + " [BarcodeFormat] : " + result.getBarcodeFormat() + " [NumBits] : " + result.getNumBits());
	}

	public static void executeForQRBytes() throws IOException {
		// 二维码内容
		String text = "http://www.nepxion.com";
		// 二维码图片导出路径
		File file = new File("/Users/hzl/Desktop/二维码.jpg");

		// 二维码参数的构造对象，很多参数赋予了默认值，可自行通过set方法更改
		ZxingEntity entity = new ZxingEntity();
		entity.setBarcodeFormat(BarcodeFormat.QR_CODE);
		entity.setLogoFile(new File("src/test/resources/logo.png"));
		entity.setText(text);
		entity.setOutputFile(file);
		entity.setWidth(430);
		entity.setHeight(430);

		// 以字节数组格式读取并导出，该方式适合服务端传输给客户端调用
		ZxingEncoder encoder = new ZxingEncoder();
		byte[] bytes = encoder.encodeForBytes(entity);

		ZxingUtil.createFile(bytes, file);

		// 以字节数组格式扫描并解析
		ZxingDecoder decoder = new ZxingDecoder();
		Result result = decoder.decodeByBytes(bytes, entity.getEncoding());

		log.info("扫描结果 - [Text] : " + result.getText() + " [Timestamp] : " + result.getTimestamp() + " [BarcodeFormat] : " + result.getBarcodeFormat() + " [NumBits] : " + result.getNumBits());
	}
	/**
	 * <p>
	 * 生成条形码
	 * </p>
	 *
	 * @author hzl 2020/01/03 5:58 PM
	 */
	public static void executeForEANFile() {
		// 条形码内容
		String text = "6943620593115";
		// 条形码图片导出路径
		File file = new File("/Users/hzl/Desktop/条形码.jpg");

		// 条形码参数的构造对象，很多参数赋予了默认值，可自行通过set方法更改
		ZxingEntity entity = new ZxingEntity();
		entity.setBarcodeFormat(BarcodeFormat.EAN_13);
		entity.setText(text);
		entity.setOutputFile(file);
		entity.setWidth(560);
		entity.setHeight(200);

		// 以文件格式读取并导出，该方式适合本地调用
		ZxingEncoder encoder = new ZxingEncoder();
		encoder.encodeForFile(entity);

		// 以文件格式扫描并解析
		ZxingDecoder decoder = new ZxingDecoder();
		Result result = decoder.decodeByFile(file, entity.getEncoding());

		log.info("扫描结果 - [Text] : " + result.getText() + " [Timestamp] : " + result.getTimestamp() + " [BarcodeFormat] : " + result.getBarcodeFormat() + " [NumBits] : " + result.getNumBits());
	}

	public static void executeForEANBytes() throws IOException {
		// 条形码内容
		String text = "6943620593115";
		// 条形码图片导出路径
		File file = new File("/Users/hzl/Desktop/条形码.png");

		// 条形码参数的构造对象，很多参数赋予了默认值，可自行通过set方法更改
		ZxingEntity entity = new ZxingEntity();
		entity.setBarcodeFormat(BarcodeFormat.EAN_13);
		entity.setText(text);
		entity.setOutputFile(file);
		entity.setWidth(560);
		entity.setHeight(200);

		// 以字节数组格式读取并导出，该方式适合服务端传输给客户端调用
		ZxingEncoder encoder = new ZxingEncoder();
		byte[] bytes = encoder.encodeForBytes(entity);

		ZxingUtil.createFile(bytes, file);

		// 以字节数组格式扫描并解析
		ZxingDecoder decoder = new ZxingDecoder();
		Result result = decoder.decodeByBytes(bytes, entity.getEncoding());

		log.info("扫描结果 - [Text] : " + result.getText() + " [Timestamp] : " + result.getTimestamp() + " [BarcodeFormat] : " + result.getBarcodeFormat() + " [NumBits] : " + result.getNumBits());
	}

	//返回条形码字节流
	public static byte[] executeForEANBytesReturn() throws IOException {
		// 条形码内容
		String text = "6943620593115";

		// 条形码参数的构造对象，很多参数赋予了默认值，可自行通过set方法更改
		ZxingEntity entity = new ZxingEntity();
		entity.setBarcodeFormat(BarcodeFormat.EAN_13);
		entity.setText(text);
		//entity.setOutputFile(file);
		entity.setWidth(560);
		entity.setHeight(200);

		// 以字节数组格式读取并导出，该方式适合服务端传输给客户端调用
		ZxingEncoder encoder = new ZxingEncoder();
		byte[] bytes = encoder.encodeForBytes(entity);

		//ZxingUtil.createFile(bytes, file);

		// 以字节数组格式扫描并解析
		ZxingDecoder decoder = new ZxingDecoder();
		Result result = decoder.decodeByBytes(bytes, entity.getEncoding());

		log.info("扫描结果 - [Text] : " + result.getText() + " [Timestamp] : " + result.getTimestamp() + " [BarcodeFormat] : " + result.getBarcodeFormat() + " [NumBits] : " + result.getNumBits());
		return bytes;
	}
}
