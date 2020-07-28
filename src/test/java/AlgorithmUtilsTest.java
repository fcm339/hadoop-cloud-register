import com.hzl.hadoop.util.AlgorithmUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * description
 *
 * @author hzl 2020/07/21 4:04 PM
 */
public class AlgorithmUtilsTest {
	@Test

	public void bubblingTest() {

		int[] array = {9, 1, 7, 8, 3};
		int[] result;
		//调用冒泡排序
		result = AlgorithmUtils.bubbling(array);
		System.out.println("冒泡排序结果" + Arrays.toString(result));
	}
}
