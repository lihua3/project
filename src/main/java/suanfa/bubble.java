package suanfa;

public class bubble {
    public static void main(String[] args) {
        int a[]={3,7,5,2,1};

        for(int i=1;i<=a.length-1;i++){

            for(int j=0;j<=a.length-i-1;j++){
                if(a[j]>a[j+1]){

                    int tmp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=tmp;
                }


            }

        }
        for(int i:a){
            System.out.println(i);

        }


    }
}
