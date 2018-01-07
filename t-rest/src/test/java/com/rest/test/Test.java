package com.rest.test;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String jsonTest = "{ \"groupOp\" :\"AND\",\"rules\":[{ \"field\":\"lastName\",\"op\":\"cn\",\"data\":\"Test\"},"
				+ "{\"field\":\"firstName\",\"op\":\"cn\",\"data\":\"Test2222\"}]}";
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		JsonNode rootNode = mapper.readValue(jsonTest, JsonNode.class);
		// 获得结点为rules的集合
		JsonNode nameNode = rootNode.path("rules");
		// 获得数据为groupOp的集合 如果不是集合则返回一个字符串
		JsonNode nameNode2 = rootNode.path("groupOp");
		System.out.println("rules:" + nameNode);
		System.out.println("groupOp:" + nameNode2);

		// 返回rulues下field对应的数组
		System.out.println("field:" + nameNode.findValues("field"));
		System.out.println("op:" + nameNode.findValues("op"));
		System.out.println("data:" + nameNode.findValues("data"));
	}

/*	public void test() {
		  String str = "{/"CellPhone/":/"0963198851/",/"Email/":/"02026@foodchina.com.tw/",/"RealName/":/"吳小姐/"}";
		  JsonParser parser = factory.createJsonParser(str); 
		  parser.nextToken();
		  while(parser.nextToken()!=JsonToken.END_OBJECT){
			  parser.nextToken();
			  System.out.println(parser.getCurrentName()+":"+parser.getText());
		  }
		//这种方法用来遍历json对象的每一个属性，但是不知道怎么对付数组，而且对这个nextToken很迷糊。
	}*/
}
