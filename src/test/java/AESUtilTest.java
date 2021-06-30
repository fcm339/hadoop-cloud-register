import com.hzl.hadoop.util.AESUtil;
import com.hzl.hadoop.util.IoUtils;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * description
 *
 * @author hzl 2020/03/09 4:35 PM
 */
public class AESUtilTest {

	//文件加密
	@Test
	public void encryptFile() throws IOException {
		FileSystemResource tempInputStream = new FileSystemResource("/Users/hzl/Desktop/ss.pdf");
		byte[] output = IoUtils.inputStreamTOByteArray(tempInputStream.getInputStream());
		String reslul = AESUtil.encryptFile(output, "test");
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/hzl/Desktop/2.pdf");
		fileOutputStream.write(reslul.getBytes("utf-8"));
	}

	//文件解密
	@Test
	public void decryptFile() throws IOException {
		FileSystemResource tempInputStream = new FileSystemResource("/Users/hzl/Desktop/2.pdf");
		byte[] output = IoUtils.inputStreamTOByteArray(tempInputStream.getInputStream());

		FileOutputStream fileOutputStream = new FileOutputStream("/Users/hzl/Desktop/3.pdf");
		fileOutputStream.write(AESUtil.decryptFile(output, "test"));

	}
}
