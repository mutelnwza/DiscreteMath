package Model1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Postfix {
    private final Deque<String> input;
    private final Deque<String> result;
    private final Deque<String> stack;

    public Postfix(ArrayList<String> expressions) {
        this.input = new ArrayDeque<>(expressions);
        this.stack = new ArrayDeque<>();
        this.result = new ArrayDeque<>();
        calculate();
    }

    private void calculate() {
        while (!input.isEmpty()) {
            String e = input.removeFirst();

            switch (e) {
                case "-", "+" -> {
                    while (!stack.isEmpty() && (stack.peek().equals("/") || stack.peek().equals("*")
                            || stack.peek().equals("+") || stack.peek().equals("-"))) {
                        result.addLast(stack.pop());
                    }
                    stack.push(e);
                }
                case "*", "/" -> {
                    while (!stack.isEmpty() && (stack.peek().equals("/") || stack.peek().equals("*"))) {
                        result.addLast(stack.pop());
                    }
                    stack.push(e);
                }
                default ->
                    result.addLast(e);
            }
        }
        while (!stack.isEmpty()) {
            result.addLast(stack.pop());
        }
    }

    public void show() {
        result.forEach(System.out::print);
    }

    public Deque<String> getOutput() {
        return result;
    }
}