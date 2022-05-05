package output;
import java.io.PrintWriter;
public class output1 {
    public static void main(String args[]) throws Exception
    {
 int[] intArray = new int[20]; 

		 intArray [1] =1;
             int x = 10 ;
        int y = 6;
        if (y == 6 ){
		 intArray [2] =1;
            x = 0;}
        else if( x < 4){
		 intArray [3] =1;
            x = 1 ;}
        else if( x > 15){
		 intArray [4] =1;
            x = 2 ;}
        else{
		 intArray [5] =1;
            x=3;}
 PrintWriter out = new PrintWriter("Text/output1.txt");
 for(int i=0 ; i< 20; i++){
     if (intArray[i] == 1)
        out.println("block#"+i);

     
 }
        out.close();
    }
}
