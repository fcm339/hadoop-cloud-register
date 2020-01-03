import org.junit.Test;
import org.springframework.core.io.FileSystemResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.hzl.hadoop.util.PdfUtil.addPdfTextMark;
import static com.hzl.hadoop.util.PdfUtil.concatPDFsAndAddPage;
import static com.hzl.hadoop.util.PdfUtil.concatPDFsNew;

/**
 * description
 *
 * @author hzl 2020/01/02 5:52 PM
 */
public class PdfUtilTest {

	@Test
	public void concatPDFsNewTest() throws Exception {
		try {

			String file1 = "http://10.200.254.53:8080/hfle/v1/0/files/download-by-key?fileKey=0/1a1d2260dc9a4e5281a0617f92c712ba@%E6%B0%B8%E5%8D%87sql%E6%96%87%E6%A1%A3.pdf&access_token=ad8d22d7-4ec6-4aa7-94de-a6b524fdea4d";
			String file2 = "http://10.200.254.53:8080/hfle/v1/0/files/download-by-key?fileKey=0/1a1d2260dc9a4e5281a0617f92c712ba@%E6%B0%B8%E5%8D%87sql%E6%96%87%E6%A1%A3.pdf&access_token=ad8d22d7-4ec6-4aa7-94de-a6b524fdea4d";
			String savePath = "/Users/hzl/Desktop/测试.pdf";
			List<String> streamOfPDFFiles = new ArrayList<>();
			streamOfPDFFiles.add(file1);
			streamOfPDFFiles.add(file2);
			OutputStream outputStream = new FileOutputStream(savePath);
			concatPDFsNew(streamOfPDFFiles, outputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public  void concatPDFsAndAddPageTest() throws Exception {
		try {

			String file1 = "http://10.200.254.53:8080/hfle/v1/0/files/download-by-key?fileKey=0/1a1d2260dc9a4e5281a0617f92c712ba@%E6%B0%B8%E5%8D%87sql%E6%96%87%E6%A1%A3.pdf&access_token=ad8d22d7-4ec6-4aa7-94de-a6b524fdea4d";
			String file2 = "http://10.200.254.53:8080/hfle/v1/0/files/download-by-key?fileKey=0/1a1d2260dc9a4e5281a0617f92c712ba@%E6%B0%B8%E5%8D%87sql%E6%96%87%E6%A1%A3.pdf&access_token=ad8d22d7-4ec6-4aa7-94de-a6b524fdea4d";
			String savePath = "/Users/hzl/Desktop/测试.pdf";
			List<String> streamOfPDFFiles = new ArrayList<>();
			streamOfPDFFiles.add(file1);
			streamOfPDFFiles.add(file2);
			OutputStream outputStream = new FileOutputStream(savePath);
			concatPDFsAndAddPage(streamOfPDFFiles, outputStream,true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    /**
     * <p>
     * 待修复测试
     * </p>
     * 
     * @author hzl 2020/01/02 7:25 PM
     */
	@Test
	public void addWaterCode(){
		OutputStream outputStream = null;

		ByteArrayOutputStream tempOutputStream = new ByteArrayOutputStream();

		String url = "http://www.baidu.com";
		String content = "随意插入";
		String water = "hadoop";

		try {
			FileSystemResource tempInputStream = new FileSystemResource("/Users/hzl/Desktop/测试.pdf");
			//FileInputStream fileInputStream =new FileInputStream(new File("/Users/hzl/Desktop/测试.pdf"));
			outputStream=new FileOutputStream("/Users/hzl/Desktop/tt.pdf");
			addPdfTextMark(tempInputStream.getInputStream(), tempOutputStream, water, 200, 200, url, content);
			outputStream.write(tempOutputStream.toByteArray());
			tempOutputStream.flush();
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
