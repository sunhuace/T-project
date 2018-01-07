package com.project.commom.utils;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义响应结构 使用JackSon
 * <p>Title: JsonUtils</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月7日下午5:24:09
 * @version 1.0
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param clazz 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
    /**
     * 取得JSON数据中的一个字段 将字段对应的列表转换为数据
     * <p>Title: getFiledToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param field
     * @return
     */
    @Test
    public static <T> List<T> getFiledToList(String jsonData, String field) {
		try {
			JsonNode rootNode = MAPPER.readValue(jsonData, JsonNode.class);
			JsonNode nameNode = rootNode.path(field);
			// 获得数据为groupOp的集合 如果不是集合则返回一个字符串
			JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, Object.class);
			List<T> list = MAPPER.readValue(nameNode.toString(), javaType);
    		return list;
		} catch (Exception e) {
		}
    	return null;
    }
    
    public static void main(String[] args) {
    	String jsonTest = "{ \"groupOp\" :\"AND\",\"rules\":[{ \"field\":\"lastName\",\"op\":\"cn\",\"data\":\"Test\"},"
				+ "{\"field\":\"firstName\",\"op\":\"cn\",\"data\":\"Test2222\"}]}";
    	List<Object> filedToList = getFiledToList(jsonTest, "rules");
    	System.out.println(filedToList);
	}
}
