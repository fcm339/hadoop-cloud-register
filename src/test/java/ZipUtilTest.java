import com.hzl.hadoop.util.ZipUtil;
import org.junit.Test;

/**
 * description
 * zip压缩测试类
 *
 * @author hzl 2020/01/17 10:28 PM
 */
public class ZipUtilTest {

	@Test
	public void zip() {
		try {
			ZipUtil.zip("/Users/hzl/Downloads/活动策划服务合同补充协议.pdf", "/Users/hzl/Downloads/tt.zip");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void unzip() throws Exception {
		ZipUtil.unZip("/Users/hzl/Downloads/tt.zip", "/Users/hzl/Downloads");

	}

	@Test
	public void tar() throws Exception {
		String[] filesPathArray = new String[1];
		filesPathArray[0] = "/Users/hzl/Downloads/活动策划服务合同补充协议.pdf";
		ZipUtil.tarCompression(filesPathArray, "/Users/hzl/Downloads/tt.tar");
	}


	@Test
	public void untar() throws Exception {
		ZipUtil.tarDecompression("/Users/hzl/Downloads/tt.tar", "/Users/hzl/Downloads/");
	}

	@Test
	public void gzip() throws Exception {
		String filesPathArray = "/Users/hzl/Downloads/活动策划服务合同补充协议.pdf";
		ZipUtil.gzipCompression(filesPathArray, "/Users/hzl/Downloads/tt.gz");
	}

	/**
	 * <p>
	 * 测试不通过
	 * </p>
	 *
	 * @author hzl 2020/01/17 11:04 PM
	 */
	@Test
	public void upgzip() throws Exception {
		ZipUtil.gzipDecompression("/Users/hzl/Downloads/tt.gz", "/Users/hzl/Downloads/");
	}


}
