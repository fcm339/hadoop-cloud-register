import com.hzl.hadoop.util.email.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/01/05 2:19 PM
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SenMailTest {

	@Autowired
	private MailService mailService;

	@Test
	public void testFreemarkerMail() throws Exception{

		mailService.sendSimpleMail("测试Springboot发送模版邮件", "测试");

	}

}
