import java.util.Stack;

public class _04_Stack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);

        System.out.println(stack.peek()); // Top element
        System.out.println(stack.pop()); // Removes top
        System.out.println(stack.isEmpty());
    }
}
