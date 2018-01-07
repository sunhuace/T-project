package com.rest.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrTest {

	// 创建一个连接
	@Test
	public void addDocument() throws SolrServerException, IOException {
		SolrServer solrServer = new HttpSolrServer("http://192.168.8.7:8080/solr");
		// 创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test001");
		document.addField("item_title", "测试商品2");
		document.addField("item_price", 54321);
		// 把文档对象写入索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();
	}
	
	@Test
	public void deleteDocument() throws Exception {
		//创建一连接
		SolrServer solrServer = new HttpSolrServer("http://192.168.8.7:8080/solr");
		//solrServer.deleteById("test001");
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
	
	@Test
	public void testArray() {
		byte[] bytes = {10, 13, 13, 10};
		Set set = new HashSet<>();
		for (int i = 0; i < bytes.length; i++) {
		}
	}


}
