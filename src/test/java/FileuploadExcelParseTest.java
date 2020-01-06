import com.hzl.hadoop.RegisterApplication;
import com.hzl.hadoop.util.ExcelParseToMapUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * description
 * 文件上传和excel解析测试
 *
 * @author hzl 2020/01/06 12:14 PM
 */
@SpringBootTest(classes = RegisterApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
@WebAppConfiguration
public class FileuploadExcelParseTest {
	@Before
	public void init() {
		System.out.println("开始测试-----------------");
	}

	@After
	public void after() {
		System.out.println("测试结束-----------------");
	}


	@Test
	public void upload() {

		try {
			File file = new File("/Users/hzl/Desktop/永升物业_业财一体化（一期）项目_签约主体导入脚本1.3.xlsx");

			FileInputStream fileInputStream = new FileInputStream(file);

			MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
					ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);

			log.info(ExcelParseToMapUtil.parseExcelFile(multipartFile).toString());
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
