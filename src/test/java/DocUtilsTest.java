import com.hzl.hadoop.util.DocUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * description
 *
 * @author hzl 2020/10/31 11:22 AM
 */
public class DocUtilsTest {


	/**
	 * 输出CoreProperties信息
	 */
	@Test
	public void getWordText() {
		File file = new File("/Users/hzl/Desktop/23333.doc");
		try {
			System.out.println(DocUtils.wordToString(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void getWordTableText() throws Exception {
//		DocUtils.testReadByDoc();
//	}


}
