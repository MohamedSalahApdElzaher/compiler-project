package output;
import java.io.PrintWriter;

public class output2 {
    public static void main(String args[]) throws Exception
    {
 int[] intArray = new int[20]; 

		 intArray [1] =1;
        int number=20;
        switch(number){
            case 10:{
		 intArray [2] =1;
                System.out.println("10");
            }
                break;
            case 20: {
		 intArray [3] =1;
                System.out.println("20");
            }
                break;
            case 30:{
		 intArray [4] =1;
                System.out.println("30");
            }
                break;
            default:System.out.println("Not in 10, 20 or 30");
        }
 PrintWriter out = new PrintWriter("Text/output2.txt");
 for(int i=0 ; i< 20; i++){
     if (intArray[i] == 1)
        out.println("block#"+i);

     
 }
        out.close();

    }
}
