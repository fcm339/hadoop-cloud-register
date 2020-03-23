import com.hzl.hadoop.util.seal.SealUtil;
import com.hzl.hadoop.util.seal.configuration.SealCircle;
import com.hzl.hadoop.util.seal.configuration.SealConfiguration;
import com.hzl.hadoop.util.seal.configuration.SealFont;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

/**
 * description
 * 印章图片生成测试类
 *
 * @author hzl 2020/03/23 10:56 AM
 */
@Slf4j
public class SealTest {

	@Test
	public void createSeal() throws Exception {
		/**
		 * 印章配置文件
		 */
		SealConfiguration configuration = new SealConfiguration();

		/**
		 * 主文字
		 */
		SealFont mainFont = new SealFont();
		mainFont.setBold(true);
		mainFont.setFontFamily("楷体");
		mainFont.setMarginSize(10);
		/**************************************************/
		mainFont.setFontText("欢乐无敌制图网淘宝店专用章");
		mainFont.setFontSize(35);
		mainFont.setFontSpace(35.0);
		/**************************************************/
		//mainFont.setFontText("ZHITUWANG CO.LTDECIDDO SH  NANNINGSHI");
		//mainFont.setFontSize(20);
		//mainFont.setFontSpace(15.0);
		/**************************************************/
//		mainFont.setFontText("欢乐无敌制图网淘宝店专用章");
//		mainFont.setFontSize(25);
//		mainFont.setFontSpace(12.0);

		/**
		 * 副文字
		 */
		SealFont viceFont = new SealFont();
		viceFont.setBold(true);
		viceFont.setFontFamily("宋体");
		viceFont.setMarginSize(5);
		/**************************************************/
		//viceFont.setFontText("123456789012345");
		//viceFont.setFontSize(13);
		//viceFont.setFontSpace(12.0);
		/**************************************************/
		viceFont.setFontText("正版认证");
		viceFont.setFontSize(22);
		viceFont.setFontSpace(12.0);

		/**
		 * 中心文字
		 */
		SealFont centerFont = new SealFont();
		centerFont.setBold(true);
		centerFont.setFontFamily("宋体");
		/**************************************************/
		centerFont.setFontText("★");
		centerFont.setFontSize(100);
		/**************************************************/
		//centerFont.setFontText("淘宝欢乐\n制图网淘宝\n专用章");
		//centerFont.setFontSize(20);
		/**************************************************/
		//centerFont.setFontText("123456789012345");
		//centerFont.setFontSize(20);
		/**************************************************/
//		centerFont.setFontText("收款专用");
//		centerFont.setFontSize(25);

		/**
		 * 抬头文字
		 */
		SealFont titleFont = new SealFont();
		titleFont.setBold(true);
		titleFont.setFontFamily("宋体");
		titleFont.setFontSize(22);
		/**************************************************/
		//titleFont.setFontText("发货专用");
		//titleFont.setMarginSize(68);
		//titleFont.setFontSpace(10.0);
		/**************************************************/
		titleFont.setFontText("正版认证");
		titleFont.setMarginSize(68);
		titleFont.setMarginSize(27);

		/**
		 * 添加主文字
		 */
		configuration.setMainFont(mainFont);
		/**
		 * 添加副文字
		 */
		configuration.setViceFont(viceFont);
		/**
		 * 添加中心文字
		 */
		configuration.setCenterFont(centerFont);
		/**
		 * 添加抬头文字
		 */
		//configuration.setTitleFont(titleFont);

		/**
		 * 图片大小
		 */
		configuration.setImageSize(300);
		/**
		 * 背景颜色
		 */
		configuration.setBackgroudColor(Color.RED);
		/**
		 * 边线粗细、半径
		 */
		configuration.setBorderCircle(new SealCircle(3, 140, 140));
		//configuration.setBorderCircle(new SealCircle(3, 140, 100));
		/**
		 * 内边线粗细、半径
		 */
		configuration.setBorderInnerCircle(new SealCircle(1, 135, 135));
		//configuration.setBorderInnerCircle(new SealCircle(1, 135, 95));
		/**
		 * 内环线粗细、半径
		 */
		//configuration.setInnerCircle(new SealCircle(2, 105, 105));
		//configuration.setInnerCircle(new SealCircle(2, 85, 45));

		//1.生成公章
		try {
			SealUtil.buildAndStoreSeal(configuration, "/Users/hzl/Desktop/公章.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//2.生成私章
		SealFont font = SealFont.builder()
				.fontSize(120)
				.bold(true)
				.fontText("李白印章")
				.build();

		SealUtil.buildAndStorePersonSeal(300, 16, font, "印章", "/Users/hzl/Desktop/私章.png");
	}

	/**
	 * 生成圆形印章
	 *
	 * @return
	 * @author hzl 2020-03-23 11:22 AM
	 */
	@Test
	public void circle() throws Exception {


		/**
		 * 主文字
		 */
		SealFont mainFont = SealFont.builder()
				.bold(true)
				.fontText("欢乐无敌制图网淘宝店专用章")
				.fontSize(35)
				.fontSpace(35.0)
				.build();

		/**
		 * 副文字
		 */
		SealFont viceFont = SealFont.builder()
				.bold(true)
				.fontFamily("宋体")
				.fontText("人事用章")
				.marginSize(5)
				.fontSpace(30.0)
				.fontSize(22)
				.build();


		/**
		 * 中心文字 todo 内容没有在圆心
		 */
		SealFont centerFont = SealFont.builder()
				.bold(true)
				.fontFamily("宋体")
				.fontSize(100)
				.fontText("★")
				.build();


		/**
		 * 抬头文字
		 */
		SealFont titleFont = SealFont.builder()
				.bold(true)
				.fontFamily("宋体")
				.fontSize(22)
				.fontText("正版认证")
				.marginSize(68)
				.build();

		/**
		 * 印章配置文件
		 */
		SealConfiguration configuration = SealConfiguration.builder()
				/**
				 * 添加主文字
				 */
				.mainFont(mainFont)
				/**
				 * 添加副文字
				 */
				.viceFont(viceFont)
				/**
				 * 添加中心文字
				 */
				.centerFont(centerFont)
				/**
				 * 添加抬头文字
				 */
				.titleFont(titleFont)
				/**
				 * 图片大小
				 */
				.imageSize(300)
				/**
				 * 背景颜色
				 */
				.backgroudColor(Color.RED)
				.borderCircle(new SealCircle(3, 140, 140))
				.borderInnerCircle(new SealCircle(1, 135, 135))
				.innerCircle(new SealCircle(2, 105, 105))
				.build();

		//1.生成公章
		SealUtil.buildAndStoreSeal(configuration, "/Users/hzl/Desktop/公章.png");


		//2.生成私章
		SealFont font = SealFont.builder()
				.fontSize(120)
				.bold(true)
				.fontText("李白印章")
				.build();

		SealUtil.buildAndStorePersonSeal(300, 16, font, "印章", "/Users/hzl/Desktop/私章.png");

	}
}
