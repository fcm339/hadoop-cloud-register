import org.junit.Test;

import java.io.IOException;

import static com.hzl.hadoop.util.IoUtils.testRead;

/**
 * description
 *
 * @author hzl 2020/01/14 5:04 PM
 */
public class FileTest {

	@Test
	public void fileContentRead() {
		try {
			testRead();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
