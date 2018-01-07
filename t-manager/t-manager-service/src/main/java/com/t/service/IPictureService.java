package com.t.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface IPictureService {
	
	/**
	 * 多图片上传 返回为结果数据
	 * <p>Title: uploadPicture</p>
	 * <p>Description: </p>
	 * @param uploadFile
	 * @return
	 */
	Map<String, Object> uploadPicture(MultipartFile uploadFile);
}
