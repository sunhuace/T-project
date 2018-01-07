package com.t.test;

import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {
	
	@Test
	public void testFTPClient() throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.8.5", 21);
		ftpClient.login("ftpuser", "root");
		FileInputStream inputStream = new FileInputStream("G:/生活娱乐/青海之行/IMG_20160619_132828.jpg");
		ftpClient.changeWorkingDirectory("/home/ftpuser/www");//指定上传文件的路径
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//指定上传文件的编码格式
		//服务器端的文件名字 本地文件的流
		ftpClient.storeFile("tt.jpg", inputStream);
		ftpClient.logout();
	}
}
