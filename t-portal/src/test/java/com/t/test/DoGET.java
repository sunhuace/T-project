package com.t.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DoGET {
	public static void main(String[] args) throws Exception {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建http GET请求
		HttpGet httpGet = new HttpGet("http://www.baidu.com/");

		CloseableHttpResponse response = null;
		try {
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				System.out.println("内容长度：" + content.length());
				// FileUtils.writeStringToFile(new File("C:\\baidu.html"),
				// content);
			}
		} finally {
			if (response != null) {
				response.close();
			}
			httpclient.close();
		}

	}

}
