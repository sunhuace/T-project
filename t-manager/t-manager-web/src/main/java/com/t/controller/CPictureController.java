package com.t.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.commom.utils.JsonUtils;
import com.t.service.IPictureService;

/**
 * 图片上传Controller 
 * <p>Title: CPictureController</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月7日下午5:19:29
 * @version 1.0
 */
@Controller("cPictureController")
public class CPictureController {
	
	@Autowired
	private IPictureService iPictureService;
	
	/**
	 * 将图片上传到服务器
	 * <p>Title: pictureUpload</p>
	 * <p>Description: </p>
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping(value="/pic/upload", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pictureUpload(@RequestParam(value="uploadFile") MultipartFile uploadFile) {
		Map<String, Object> uploadPicture = iPictureService.uploadPicture(uploadFile);
		String json = JsonUtils.objectToJson(uploadPicture);
		return json;
	}
}
