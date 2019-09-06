package baiduProject;

import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class uploadPic {
    public static void main(String[] args) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://www.testingedu.com.cn:8000/index.php/home/Uploadify/imageUp/savepath/head_pic/pictitle/banner/dir/images.html");

        //创建multipartEntityBuilder 用于完成请求的封装
        MultipartEntityBuilder mtp = MultipartEntityBuilder.create();
        //对每个请求进行封装
        File f = new File("d:\\jinmao.jpg");
        mtp.addBinaryBody("file",f);

        mtp.addTextBody("id", "WU_FILE_0");
        mtp.addTextBody("name", "logo_500x500.png");

        //通过multipartbuilder创建实体
        HttpEntity build = mtp.build();
        httpPost.setEntity(build);

        //执行请求

        CloseableHttpResponse res = client.execute(httpPost);

        HttpEntity entity = res.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);

        //解析结果
        String state = JsonPath.read(s, "$.state");
        System.out.println("state is " + state);

    }
}
