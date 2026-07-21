package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class PSE {
    public static void main(String[] args) {
        int arr[]={4,5,2,10,8};
        int n=arr.length;
        int pse[]=new int[n];

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        Arrays.stream(pse).forEach(System.out::println);
    }
}
