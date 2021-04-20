import java.util.*;
public class NextGen_HelloWorld
{
    public static void main(String Args[])
    throws InterruptedException{
        Scanner ob=new Scanner(System.in);
        System.out.println("Please Enter the delay duration in Seconds");
        int time=ob.nextInt();
        Thread.sleep(1000);
        while(true)
        { 
            for(int i=time;i>0;i--)
            {
                System.out.print(i+" ");
                System.out.println();
                Thread.sleep(1000);
            }
            System.out.println("Hello World!");
            Thread.sleep(1000);
        }
    }
}
