import com.hzl.hadoop.util.MoneyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * description
 * 金额大写测试类
 * @author hzl 2020/01/06 11:24 AM
 */
@Slf4j
public class MoneyUpperTest {

	@Test
	public void number2CNMontrayUnit(){
		BigDecimal bigDecimal = new BigDecimal(1922343.99);

		log.info(MoneyUtil.number2CNMontrayUnit(bigDecimal));
	}
}
