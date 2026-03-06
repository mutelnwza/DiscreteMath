import java.util.ArrayList;
import java.util.Arrays;

public class Calculate {
    public static void PostCal(String[] input) {
        ArrayList<Integer> stack = new ArrayList<>();
        int i = 1;
        System.out.println();
        for (String string : input) {
            System.out.println("\t[Round " + i + "]\n\t[Stack] = " + stack + "\n\t[LOOKING AT] = " + string);
            i++;
            if (string.charAt(0) > 47 && string.charAt(0) < 58) {
                System.out.println("\t[PUSH]: " + string);
                stack.add(Integer.parseInt(string));
            } else {
                System.out.println("\t[POP]: " + stack.getLast());
                int b = stack.removeLast();
                System.out.println("\t[POP]: " + stack.getLast());
                int a = stack.removeLast();
                System.out.println("\t[Calculate]: " + a + " " + string + " " + b);
                int cal = Integer.MIN_VALUE;
                switch (string) {
                    case "+":
                        cal = a + b;
                        break;
                    case "-":
                        cal = a - b;
                        break;
                    case "*":
                        cal = a * b;
                        break;
                    case "/":
                        cal = a / b;
                        break;
                }
                System.out.println("\t[Push]: " + cal);
                stack.add(cal);
            }
            System.out.println();
        }
        System.out.println("THE ANSWER IS: " + stack.getFirst());
    }
}
