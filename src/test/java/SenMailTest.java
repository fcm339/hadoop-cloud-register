import com.hzl.hadoop.RegisterApplication;
import com.hzl.hadoop.util.email.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/01/05 2:19 PM
 */
@SpringBootTest(classes = RegisterApplication.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Slf4j
public class SenMailTest {

	@Autowired
	private MailService mailService;

	@Before
	public void init() {
		log.info("开始测试-----------------");
	}

	@After
	public void after() {
		log.info("测试结束-----------------");
	}

	@Test
	public void testSimpleMail() {

		mailService.sendSimpleMail("测试Springboot发送模版邮件", "测试");

	}

	@Test
	public void testHtmlMail() throws Exception {
		Map<String, String> attachmentMap = new HashMap<>();
		attachmentMap.put("附件", "/Users/hzl/Desktop/测试.pdf");

		mailService.sendHtmlMail("测试Springboot发送html邮件", "<h1 style=\"color:red;\">这个是html</h1>", attachmentMap);

	}

	@Test
	public void sendTemplateMail() throws IOException {
		Map<String, String> attachmentMap = new HashMap<>();
		attachmentMap.put("附件", "/Users/hzl/Desktop/测试.pdf");

		mailService.sendTemplateMail("freemarker邮件测试", attachmentMap);
	}

}
