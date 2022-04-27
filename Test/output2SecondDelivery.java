package output;
public class output {
    public static void main(String[] args) {
        int x = 2 ;
        int y = 5;
        if (x > 2){
		System.out.println("Block #0");
            y = 8;
        }
        else{
		System.out.println("Block #1");
            y = 1;
        }
        System.out.println(y);
    }
}
