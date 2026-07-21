package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
    public static void main(String[] args) {
        int arr[]={4,12,5,3,1,2,5,3,1,2,4,6};
        int nge[]=new int[arr.length];

        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(arr[i]);
                nge[i]=-1;
            }
            else if(stack.peek()>arr[i]){
                nge[i]=stack.peek();
                stack.push(arr[i]);
            }
            else if(stack.peek()<arr[i]){
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    nge[i]=stack.peek();
                    stack.push(arr[i]);
                }
                else{
                    stack.push(arr[i]);
                    nge[i]=-1;
                }
            }

//            while(!stack.isEmpty() && stack.peek()<=arr[i]){
//                stack.pop();
//            }
//            if(!stack.isEmpty()){
//                nge[i]=stack.peek();
//            }
//            else{
//                nge[i]=-1;
//            }
//            stack.push(arr[i]);
        }
        Arrays.stream(nge).forEach(System.out::print);
    }
}
