package baiduProject;

import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class logint {
    public static void main(String[] args) throws IOException {
        gettoken();
        login(gettoken());

    }

    private static void login(String token) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/login?username=Will&password=123456");

        //设置头域
        httpPost.setHeader("token",token);

        //获取返回 解析返回体内容
        CloseableHttpResponse res = client.execute(httpPost);
        HttpEntity entity = res.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);




        HttpPost httpPost2 = new HttpPost("http://testingedu.com.cn/inter/HTTP/login?username=Will&password=123456");
        httpPost2.setHeader("token",token);
        String s2 = EntityUtils.toString(client.execute(httpPost2).getEntity());
        System.out.println(s2);


    }

    public static String gettoken() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://testingedu.com.cn/inter/HTTP/auth");
        CloseableHttpResponse res = client.execute(httpPost);
        HttpEntity entity = res.getEntity();
        String s = EntityUtils.toString(entity);
        String token = JsonPath.read(s, "token");
        return token;
    }
}
