package com.example.demo;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class test {
    public static void main( String[] args ) throws Exception, NestedRuntimeException
    {
		//headers
	        HttpHeaders requestHeaders = new HttpHeaders();
	        //requestHeaders.add("api-version", "1.0");
	        requestHeaders.setContentType(MediaType.TEXT_XML);
	        //requestHeaders.set("Content-Type", "text/xml");
	        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
	        		"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
	        		"  <soap:Body>\r\n" + 
	        		"    <qqCheckOnline xmlns=\"http://WebXml.com.cn/\">\r\n" + 
	        		"      <qqCode>string</qqCode>\r\n" + 
	        		"    </qqCheckOnline>\r\n" + 
	        		"  </soap:Body>\r\n" + 
	        		"</soap:Envelope>";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(xml, requestHeaders);

	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx", requestEntity, String.class);
	        //ResponseEntity<String> responseEntity = restTemplate.exchange("http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx",HttpMethod.POST,requestEntity,String.class,xml);
	        System.out.println(responseEntity.getBody());
    }
	//http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx?op=qqCheckOnline
}
