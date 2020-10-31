import com.hzl.hadoop.gp.constant.GpUrlConstant;
import com.hzl.hadoop.gp.yili.Convert;
import com.hzl.hadoop.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * description
 * 股票接口测试
 *
 * @author hzl 2020/10/31 1:47 PM
 */
@Slf4j
public class GpTest {

	//伊利股票信息获取
	@Test
	public void getYl() {
		Convert convert = new Convert();
		Map<String, String> date = convert.getGpInfo(GpUrlConstant.YL_URL, null);
		log.info(JsonUtils.mapToJson(date).toJSONString());
	}

	//美的股票信息获取
	@Test
	public void getMd() {
		Convert convert = new Convert();
		Map<String, String> date = convert.getGpInfo(GpUrlConstant.MD_URL, null);
		log.info(JsonUtils.mapToJson(date).toJSONString());
	}
}