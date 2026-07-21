import java.util.Stack;

public class InfixToPrefix {
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return -1;
    }
    public static void main(String[] args) {
        String str="a^(b*c+d)";
        Stack<Character> stack=new Stack<>();
        Stack<String> sb=new Stack<>();


        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                sb.push(ch+"");
            }
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    String op1 = sb.pop();
                    String op2 = sb.pop();
                    String nw = stack.pop() + op2 + op1;
                    sb.push(nw);
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && priority(ch)<priority(stack.peek())){
                    String op1 = sb.pop();
                    String op2 = sb.pop();
                    String nw = stack.pop() + op2 + op1;
                    sb.push(nw);
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            String op1 = sb.pop();
            String op2 = sb.pop();
            String nw = stack.pop() + op2 + op1;
            sb.push(nw);
        }

        System.out.println(sb.pop());
    }
}
