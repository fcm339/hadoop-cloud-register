package com.hzl.hadoop.util;

import org.apache.commons.lang3.StringUtils;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * description
 * 获取打印设备
 * 打印参考：https://my.oschina.net/960823/blog/2994220
 * @author hzl 2020/12/08 10:16 PM
 */
public class PrintServerUtils {

	PrintService[] service = PrintServiceLookup.lookupPrintServices(null, null);

	//获取打印设备
	private void print() {

		for (int i = 0; i < service.length; i++) {

			System.out.println(service[i].getName());

		}

	}


	/**
	 * 获取同网络段下的设备信息
	 *
	 * @param host 192.168.199
	 * @return
	 * @author hzl 2020-12-08 10:30 PM
	 */
	private void getNetMachine(String host) {
		try {
			//设置IP地址网段
			InetAddress localHost = InetAddress.getLocalHost();
			String hostAddress = localHost.getHostAddress();
			System.out.println("当前网络信息" + hostAddress.substring(0, hostAddress.lastIndexOf(".")));
			String ips = StringUtils.isBlank(host) ? hostAddress.substring(0, hostAddress.lastIndexOf(".")) : host;
			String ip;
			InetAddress addip;
			//遍历IP地址
			for (int i = 1; i < 255; i++) {
				ip = ips + "." + i;
				addip = InetAddress.getByName(ip);
				//获取登录过的设备
				if (!ip.equals(addip.getHostName())) {
					//检查设备是否在线，其中1000ms指定的是超时时间
					boolean status = InetAddress.getByName(addip.getHostName()).isReachable(1000);     // 当返回值是true时，说明host是可用的，false则不可。
					System.out.println("IP地址为:" + ip + "\t\t设备名称为: " + addip.getHostName() + "\t\t是否可用: " + (status ? "可用" : "不可用"));
				}
			}
		} catch (java.io.IOException uhe) {
			System.err.println("Unable to find: " + uhe.getLocalizedMessage());
		}
	}


	/**
	 * 通过 IP+端口 连接打印机打印文件
	 *
	 * @param filePath
	 * @throws Exception
	 */
	public static void print(String filePath, String ip) throws Exception {
		File file = new File(filePath); // 获取选择的文件
		Socket socket = new Socket(ip, 9100);

		OutputStream out = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		//建立数组
		byte[] buf = new byte[1024];
		int len = 0;
		//判断是否读到文件末尾
		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		//告诉服务端，文件已传输完毕
		socket.shutdownOutput();
		socket.close();
		fis.close();
	}

	//获取同网络段下的设备信息
	public static void main(String[] args) {
		new PrintServerUtils().getNetMachine(null);
	}
}
