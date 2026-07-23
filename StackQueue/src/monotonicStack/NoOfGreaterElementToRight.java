package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NoOfGreaterElementToRight {
    public static void main(String[] args) {
        int arr[]={4,12,5,3,1,2,5,3,1,2,4,6};
        int n=arr.length;
        int nge[]=new int[n];

        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i]=-1;
            }
            else{
                nge[i]=stack.size();
            }
            stack.push(arr[i]);
        }

        Arrays.stream(nge).forEach(System.out::println);
    }
}
