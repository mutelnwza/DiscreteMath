import java.text.ListFormat.Style;
import java.util.Scanner;

public class Model1 {
    public void Start() {
        // Attributes
        boolean run = true;
        String[] input;

        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Function: ");
        input = sc.nextLine().split("\\s+");// EXAMPLE RN: 3 4 + 5 *
        System.out.println();

        String select;

        while (run) {
            System.out.println(
                    "Select Your Options:\n\t1.Prefix Layout\n\t2.Infix Layout\n\t3.Postfix Layout\n\t4.Calculate Using Postfix\n\t5.EXIT");
            System.out.print("INSERT 1 TO 5: ");
            select = sc.nextLine();
            System.out.println();
            switch (select) {
                case "1":
                    System.out.println("Something About Prefix");
                    break;
                case "2":
                    Infix.print(input);
                    break;
                case "3":
                    System.out.println("Something About Postfix");
                    break;
                case "4":
                    System.out.println("HERE STEP BY STEP:");
                    Calculate.PostCal(input); // PLSSSSSSSSSSSSSSSSSSSSSSSSS DO SMTH I DO NOT KNOW HOW TO POSTFIX
                    break;
                case "5":
                    run = false;
                    break;
                default:
                    System.out.println("!! Error:Wrong_Input !!");
                    break;
            }
            System.out.println();
        }
        sc.close();
    }

}