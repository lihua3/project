package bakkkk;

import com.jayway.jsonpath.JsonPath;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;



public class httpclien_demo {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String url ="http://www.testingedu.com.cn/inter/HTTP/auth";
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type","application/json");

        CloseableHttpResponse res = client.execute(httpPost);
        HttpEntity entity = res.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);
        Object token = JsonPath.read(s,"token");
        System.out.println(token);



    }
}
