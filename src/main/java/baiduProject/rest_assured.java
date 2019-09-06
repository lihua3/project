package baiduProject;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class rest_assured {
    public static void main(String[] args) {
       // String url ="https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=3.3.3.3&co=&resource_id=6006&t=1566219384661&ie=utf8&oe=gbk&cb=op_aladdin_callback&format=json&tn=baidu&cb=jQuery11020022032822398426744_1566219371741&_=1566219371747";

        String url2 ="http://www.testingedu.com.cn/inter/HTTP/auth";
        Response res = given().header("Content-type", "application/json")
                .post(url2);
        res.body().print();
       //res.then().body()
        Object msg = res.getBody().jsonPath().get("msg");
        Object token = res.getBody().jsonPath().get("token");
        System.out.println("msg is :"+msg);
        System.out.println("token is :"+token);


    }
}
