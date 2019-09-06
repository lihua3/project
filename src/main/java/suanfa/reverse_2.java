package suanfa;

public class reverse_2 {
    public static void main(String[] args) {
        String str="hello nongfu san quan";
        String[] s=str.split(" ");
        for(int i=s.length-1;i>=0;i--){
            System.out.print(s[i]+" ");

        }
    }
}
