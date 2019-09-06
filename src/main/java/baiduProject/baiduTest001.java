package baiduProject;

import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class baiduTest001 {
    public static void main(String[] args) throws IOException {

        String url ="https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=3.3.3.3&resource_id=6006&ie=utf8&oe=gbk";

        //创建默认的client进行收发包
        CloseableHttpClient client = HttpClients.createDefault();

        //创建httpget方法
        HttpGet httpGet = new HttpGet(url);

        //

        //发包 获取返回值
        CloseableHttpResponse res = client.execute(httpGet);
        //解析返回主体内容
        HttpEntity entity = res.getEntity();
        //将实体转换为字符串
        String s = EntityUtils.toString(entity);
        System.out.println(s);

        //断言 如果不是数组 则0可以去掉
        Object address= JsonPath.read(s,"data[0].location");
        System.out.println(address);
        String s2="{\"status\":\"0\",\"t\":\"\",\"set_cache_time\":\"\",\"data\":{\"location\":\"美国\",\"titlecont\":\"IP地址查询\",\"origip\":\"3.3.3.3\",\"origipquery\":\"3.3.3.3\",\"showlamp\":\"1\",\"showLikeShare\":1,\"shareImage\":1,\"ExtendedLocation\":\"\",\"OriginQuery\":\"3.3.3.3\",\"tplt\":\"ip\",\"resourceid\":\"6006\",\"fetchkey\":\"3.3.3.3\",\"appinfo\":\"\",\"role_id\":0,\"disp_type\":0}}\n";

        System.out.println(s2);
        System.out.println(JsonPath.read(s2,"$.data.location"));
    }
}
