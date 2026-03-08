import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[]arr = {"5","+","2","/","2","-","1"};
        String[]arr2= {"1","+","2","*","3","/","4"};
        ArrayList<String> a = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> a2 = new ArrayList<>(Arrays.asList(arr2));
        Prefix p = new Prefix(a2);
        Postfix post = new Postfix(a2);
        post.show();
        System.out.println();
        p.show();
    }
}
