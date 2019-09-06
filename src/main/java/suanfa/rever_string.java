package suanfa;

public class rever_string {
    public static void main(String[] args) {
        String a="hello world";
        char[]chars=a.toCharArray();
        for(int i=chars.length-1;i>=0;i--){
            System.out.print(chars[i]);
        }
    }
}
