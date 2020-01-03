package com.hzl.hadoop.app.controller;

import com.hzl.hadoop.app.vo.PaymentVO;
import com.hzl.hadoop.util.Zxing;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * description
 * 结合freeMarker和条形码生成组件，生成一个付款单
 *
 * @author hzl 2020/01/03 7:37 PM
 * @Controller才会映射到视图上，不然直接返回json给调用方
 */
@Controller
@Slf4j
public class FreeMarkerZxingController {

	@RequestMapping(value = "/paymentOrder")
	public String paymentOrder(Model model) {

		try {
			byte[] bytes = Zxing.executeForEANBytesReturn();
			String barcodeImg = Base64.encodeBase64String(bytes).toString();
			log.info("条形码字节大小" + bytes.length);
			//费用明细
			HashMap map = new HashMap();
			map.put("receiptType", "增值税发票");
			map.put("amount", "100¥");
			List<HashMap> receiptList = new ArrayList<>();
			receiptList.add(map);
			PaymentVO paymentVO = PaymentVO.builder()
					.barcodeImg("data:image/png;base64," + barcodeImg)
					.barcode("RS20198899").deptName("运营事业部")
					.reimReason("餐费")
					.userName("李白")
					.submitDate(LocalDate.now())
					.receiptList(receiptList)
					.build();
			model.addAttribute(paymentVO);
			log.info("model" + model.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "payZxing";
	}
}
