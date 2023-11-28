import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test1 {

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

	public static void main(String[] args) {
		int a = 5;
        int b = 2;
        swap(a, b);
        System.out.println(a + " " + b);
	}
}
