package output;
import java.io.PrintWriter;

public class output3 {
    public static void main(String args[]) throws Exception
    {
 int[] intArray = new int[20]; 

		 intArray [1] =1;
        int x = 1, sum = 0;
        while (x <= 10) {
		 intArray [2] =1;
            if (x<4){
		 intArray [3] =1;
                System.out.println("y");
		}
            else{
		 intArray [4] =1;
                System.out.println("yyyyy");
            }
            x ++;
        }
 PrintWriter out = new PrintWriter("Text/output3.txt");
 for(int i=0 ; i< 20; i++){
     if (intArray[i] == 1)
        out.println("block#"+i);

     
 }
        out.close();

    }
}
