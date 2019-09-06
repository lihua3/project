package login;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public class paramTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashedMap();
        map.put("idvalue","30");
        String url="http://www.baidu.com?id={idvalue}";
        for(String key:map.keySet()){
            url=url.replaceAll("\\{+key+\\}",map.get(key));

        }
        System.out.println(url);
        System.out.println("2222");

    }

}
