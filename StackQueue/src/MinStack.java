import java.util.Stack;

//class Pair{
//    int val,min;
//    Pair(int val,int min){
//        this.val=val;
//        this.min=min;
//    }
//}
public class MinStack {
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

//    private void push(int val) {
//        if(stack.isEmpty()){
//            stack.push(new Pair(val,val));
//            return;
//        }
//        stack.push(new Pair(val,Math.min(val,stack.peek().min)));
//    }
//
//    private void pop() {
//        if(stack.isEmpty()){
//            System.out.println("stack is empty");
//            return;
//        }
//        stack.pop();
//    }
//
//    private int getMin() {
//        return stack.peek().min;
//    }
//    private int top() {
//        if(stack.isEmpty()){
//            System.out.println("stack is empty");
//            return -1;
//        }
//        return stack.peek().val;
//    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.push(val);
            min=val;
        }
        if(val>=min){
            stack.push(val);
        }
        else{
            int newVal = 2 * val - min;
            min=val;
            stack.push(newVal);
        }
    }
    public int pop(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        if(stack.peek()>min){
            return stack.pop();
        }
        int temp=min;
        min = 2 * min - stack.pop();
        return temp;
    }
    public int top(){
        if(stack.isEmpty()){
            return -1;
        }
        if(stack.peek()>min){
            return stack.peek();
        }
        return min;
    }
    public int getMin(){
        return min;
    }




    public static void main(String[] args) {
        MinStack st=new MinStack();
        st.push(5);
        st.push(3);
        st.push(2);
        System.out.println("Minimum value in stack: "+st.getMin());
        st.pop();
        System.out.println("Top Element in stack: "+st.top());
        st.pop();
        System.out.println("minimum value in stack: "+st.getMin());

        
    }


}
