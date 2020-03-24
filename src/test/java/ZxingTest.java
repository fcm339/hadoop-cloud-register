import com.hzl.hadoop.util.Zxing;
import org.junit.Test;

/**
 * description
 * 条形码，二维码生成和解析测试类
 * @author hzl 2020/01/05 2:41 PM
 */
public class ZxingTest {

	@Test
	public void zkingtest() throws Exception {
		Zxing.executeForQRFile();
		// executeForQRBytes();

		//executeForEANFile();
		//Zxing.executeForEANBytes();
	}
}
