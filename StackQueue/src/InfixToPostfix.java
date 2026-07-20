import java.util.Stack;

public class InfixToPostfix{
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return -1;
    }
    public static void main(String[] args) {
        String str="3^(1+1)";
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
            else if(ch==('(')){
                stack.push(ch);
            }
            else if(ch==')'){
                if(!stack.isEmpty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && priority(ch)<priority(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
