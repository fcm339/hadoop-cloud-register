import com.hzl.hadoop.design.proxy.ProxyFactory;
import com.hzl.hadoop.design.proxy.TargetObject;
import com.hzl.hadoop.design.proxy.TargetObjectService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/07/07 4:53 PM
 */
public class ProxyTest {


	@Test
	public void proxyTest() throws Exception {
		TargetObjectService targetObjectService = new TargetObject();
		// 给目标对象，创建代理对象
		TargetObjectService proxy= (TargetObjectService) new ProxyFactory(targetObjectService).getProxyInstance();
		// 执行方法  代理对象
		int i=proxy.test1();
		System.out.println(i);
	}

}
