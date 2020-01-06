import com.hzl.hadoop.RegisterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * description
 *
 * @author hzl 2020/01/06 1:53 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegisterApplication.class)
public class DataSourceTest {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void testDataSource() throws Exception {
		// 获取配置的数据源
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		// 查看配置数据源信息
		System.out.println(dataSource.getClass().getName());
	}
}
