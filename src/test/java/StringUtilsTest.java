import com.hzl.hadoop.util.StringUtils;
import org.junit.Test;

/**
 * description
 *
 * @author hzl 2021/10/25 11:42 AM
 */
public class StringUtilsTest {

	/**
	 * 判断字符串中是否存在指定长度的数字
	 *
	 * @author hzl 2021-10-25 11:37 AM
	 * @return
	 */
	@Test
	public void hasFixNum(){

		System.out.println(StringUtils.hasLgEqFixNumStringReturn("测试45986也许34ces586111",6));
	}

}
