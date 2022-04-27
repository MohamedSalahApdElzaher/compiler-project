package output;

public class output {
    public static void main(String[] args) {
        int x = 10 ;
        int y = 20;
        if (y == 6 )
        {
		System.out.println("Block #0");
            x = 0;
        }else if( x < 4)
        {
		System.out.println("Block #1");
            x = 1 ;
        }
        else if( x > 15)
        {
		System.out.println("Block #2");
            x = 2 ;
        }
        else {
		System.out.println("Block #3");
            x=3;
        }
    }
}
/*
public class output {
    public static void main(String[] args) {
        int x = 2 ;
        int y = 5;
        if (x > 2){
            y = 8;
        }
        else{
            y = 1;
        }
        System.out.println(y);
    }
}

 */
