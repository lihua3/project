package baiduProject;

import java.util.HashMap;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

public class TokenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpClientKw kw=new HttpClientKw();
		
		try {
			//先调用auth接口
			String authResult=kw.doPost("http://www.testingedu.com.cn/inter/HTTP/auth", "");
			String tokenValue=JsonPath.read(authResult,"$.token");
			System.out.println(tokenValue);
			Map<String, String> headerMap=new HashMap<String, String>();
			headerMap.put("token", tokenValue);
			kw.addHeader(headerMap);
			kw.doPost("http://www.testingedu.com.cn/inter/HTTP/login", "username=Will&password=123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
