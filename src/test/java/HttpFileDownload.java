import com.hzl.hadoop.util.HttpUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * description
 * http 文件下载测试
 *
 * @author hzl 2020/01/06 12:49 PM
 */

public class HttpFileDownload {

	@Test
	public void download() {

		//文件保存目录
		File test = new File("/Users/hzl/Desktop/download.docx");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(test);
			fileOutputStream.write(HttpUtils.downloadData(""));
			IOUtils.closeQuietly(fileOutputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
