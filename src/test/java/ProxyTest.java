import com.hzl.hadoop.design.proxy.ProxyFactory;
import com.hzl.hadoop.design.service.TargetObjectService;
import com.hzl.hadoop.design.service.impl.TargetObjectServiceImpl;
import org.junit.Test;

/**
 * description
 *
 * @author hzl 2020/07/07 4:53 PM
 */
public class ProxyTest {

	/**
	 * 动态代理测试方法
	 *
	 * @return
	 * @author hzl 2020-11-24 3:13 PM
	 */
	@Test
	public void proxyTest() throws Exception {
		TargetObjectService targetObjectService = new TargetObjectServiceImpl();
		// 给目标对象，创建代理对象
		TargetObjectService proxy = (TargetObjectService) new ProxyFactory(targetObjectService).getProxyInstance();
		// 执行方法  代理对象
		int i = proxy.proxyTest();
		System.out.println(i);
	}

}
