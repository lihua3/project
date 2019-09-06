package baiduProject;



public class CookieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpClientKw kw=new HttpClientKw();
		kw.saveCookie();
		try {
			String loginresult=kw.doPost("http://www.testingedu.com.cn/inter/HTTP/auth", "");
			System.out.println("第一次登陆："+loginresult);
			String loginresult2=kw.doPost("http://www.testingedu.com.cn/inter/HTTP/auth", "");
			System.out.println("第二次登陆："+loginresult2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
