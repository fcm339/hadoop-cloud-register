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
		File file = new File("/Users/hzl/Desktop/Ecolab_MD060_员工管理优化_V1.1.docx");
		try {
			System.out.println(DocUtils.doc2String(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
