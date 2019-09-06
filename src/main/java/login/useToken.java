package login;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.collections.map.HashedMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class useToken {
    httKw kw = new httKw();
    private Map<String,String> map =new HashedMap();

    @BeforeMethod
    public void init() throws Exception {


        String s = kw.doPost("http://testingedu.com.cn/inter/HTTP/auth", "");

        map.put("token",(String)JsonPath.read(s,"$.token"));
        kw.addHeader(map);

    }

    @Test
    public  void login() throws Exception {

        kw.doPost("http://testingedu.com.cn/inter/HTTP/login?username=Will&password=123456","");
      // kw.doPost("http://testingedu.com.cn/inter/HTTP/login?username=Will&password=123456","");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        kw.addHeader(map);
        kw.doPost("http://testingedu.com.cn/inter/HTTP/logout","");

    }
}
