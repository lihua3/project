package baiduProject;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;

public class postJSON {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://api.test.zhulogic.com/designer_api/account/login_quick");
        //创建stringentity实体 传递json数据
        //创建stringentity实体用于记录传递的参数内容，封装成为一个实体
        StringEntity stringEntity = new StringEntity("{\"phone\": 13408041298, \"code\": \"123\", \"unionid\": \"\", \"messageType\": 3, \"channel\": \"zhulogic\"}");

        ////将字符串实体的内容设置
        stringEntity.setContentType("application/json");

        //设置post方法中发送的主体字符串实体内容
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse res = client.execute(httpPost);
        HttpEntity entity = res.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);


    }
}
