import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String str="/A+BC";
        Stack<String> stack=new Stack<>();

        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                String nw = op1 + op2 + ch;
                stack.push(nw);
            }
        }

        System.out.println(stack.pop());
    }
}
