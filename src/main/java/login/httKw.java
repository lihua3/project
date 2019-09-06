package login;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Map;
import java.util.Set;


public class httKw {
    private boolean addHeaderFlag=false;

    private CloseableHttpClient client;
    private Map<String,String> headersMap;

    public String doPost(String url,String parameter) throws Exception {
        String urlwithpara=null;

        try {
            if(parameter.length()>0){
                urlwithpara=url+"?"+parameter;
            }else {
                urlwithpara=url;
            }
            client= HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(urlwithpara);

            if(addHeaderFlag==true){
                Set<String> keySet = headersMap.keySet();
                for(String key:keySet){
                    httpPost.setHeader(key,headersMap.get(key));

                }
            }


            CloseableHttpResponse res = client.execute(httpPost);
            String result = EntityUtils.toString(res.getEntity());
            System.out.println("result is :"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            client.close();
        }
    return null;
    }

    public void addHeader(Map<String,String> headerMap){
        headersMap=headerMap;
        addHeaderFlag=true;
    }
}
