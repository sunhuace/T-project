package com.t.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.commom.utils.FtpUtil;
import com.project.commom.utils.IDUtils;
import com.t.service.IPictureService;

/**
 * 图片上传服务
 * <p>Title: IPictureServiceImpl</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月5日上午11:42:43
 * @version 1.0
 */
@Service("iPictureService")
public class IPictureServiceImpl implements IPictureService {
	
	//调用spring容器中的值 进行注入操作
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	
	@Value("${FTP_BASEPATH}")
	private String FTP_BASEPATH;
	
	@Value("${IMGE_BATHPATH}")
	private String IMGE_BATHPATH;
	
	/**
	 * 多文件上传图片
	 * <p>Title: uploadPicture</p>
	 * <p>Description: </p>
	 * @param uploadFile
	 * @return Map<String, Object>
	 * @see com.t.service.IPictureService#uploadPicture(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public Map<String, Object> uploadPicture(MultipartFile uploadFile) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<>();//用于组装kindEditor的返回数据格式
		try {
			//生成一个新的图片存储名字
			String oldImgName = uploadFile.getOriginalFilename();
			String imageName = IDUtils.genImageName();
			String newImgName = imageName + oldImgName.substring(oldImgName.lastIndexOf("."));
			String imagPath = new DateTime().toString("/yyyy/MM/dd");//指定图片在图片服务器的位置
			flag = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, "", newImgName,
					uploadFile.getInputStream());
			if(!flag) {// 如果上传失败
				map.put("error", 1);
				map.put("message", "图片上传失败!");
				return map;
			}
			//如果上传成功
			map.put("error", 0);
			map.put("url", IMGE_BATHPATH + "/" + newImgName);
			return map;
		} catch (Exception e) {
			map.put("error", 1);
			map.put("message", "图片上传失败!");
			return map;
		}
	}

}
