import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String str="abc*+";
        Stack<String> stack=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                String nw = ch + op2 + op1;
                stack.push(nw);
            }
        }
        System.out.println(stack.pop());
    }
}
