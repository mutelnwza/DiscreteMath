
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Prefix {

    private final Deque<String> input;
    private final Deque<String> result;
    private final Deque<String> stack;

    public Prefix(ArrayList<String> expressions) {
        this.input = new ArrayDeque<>(expressions);
        this.stack = new ArrayDeque<>();
        this.result = new ArrayDeque<>();

        calculate();
    }

    private void calculate() {
        while (!input.isEmpty()) {
            String e = input.removeLast();
            switch (e) {
                case "-", "+" -> {
                    while (!stack.isEmpty() && (stack.peek().equals("/") || stack.peek().equals("*"))) {
                        result.push(stack.pop());
                    }
                    stack.push(e);
                }
                case "*", "/" ->
                    stack.push(e);
                default ->
                    result.push(e);
            }
        }
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }
    }

    public void show() {
        result.forEach(System.out::print);
    }
}
