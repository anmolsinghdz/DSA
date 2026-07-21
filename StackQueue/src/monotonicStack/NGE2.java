package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NGE2 {
    public static void main(String[] args) {
        int arr[]={2,10,12,1,11};
        int n=arr.length;

        int nge[]=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    nge[i]=-1;
                }
                else{
                    nge[i]=stack.peek();
                }
            }
            stack.push(arr[i%n]);
        }

        Arrays.stream(nge).forEach(System.out::println);
    }
}
