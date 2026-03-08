package Model1;

import java.text.ListFormat.Style;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Model1 {
    protected boolean run = true;
    protected String[] input;

    public void Start() {
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
                    ArrayList<String> list1 = new ArrayList<>(Arrays.asList(input));
                    Prefix prefix = new Prefix(list1);
                    prefix.show();
                    break;
                case "2":
                    Infix.print(input);
                    break;
                case "3":
                    ArrayList<String> list2 = new ArrayList<>(Arrays.asList(input));
                    Postfix postfix = new Postfix(list2);
                    postfix.show();
                    break;
                case "4":
                    System.out.println("HERE STEP BY STEP:");
                    ArrayList<String> list3 = new ArrayList<>(Arrays.asList(input));
                    Postfix postfix2 = new Postfix(list3);
                    String[] arr = postfix2.getOutput().toArray(new String[0]);
                    Calculate.PostCal(arr); // PLSSSSSSSSSSSSSSSSSSSSSSSSS DO SMTH I DO NOT KNOW HOW TO POSTFIX
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