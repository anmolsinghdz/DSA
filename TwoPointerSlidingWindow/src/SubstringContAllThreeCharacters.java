import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubstringContAllThreeCharacters {
    public static void main(String[] args) {
        String s="bbacba";

        int n=s.length(), c=0;

        //Brute Force O(N^2) O(1)
//        int hash[]=new int[3];
//
//        for(int i=0;i<n;i++){
//            Arrays.fill(hash,0);
//            for(int j=i;j<n;j++){
//                char ch=s.charAt(j);
//                hash[ch-'a']=1;
//                if((hash[0]+hash[1]+hash[2])==3){
//                    c+=(n-j);
//                    break;
//                }
//            }
//        }
//        System.out.println(c);

        //Optimal Approach
        Map<Character,Integer> map=new HashMap<>();
        int l=0, r=0;
        while(r<n){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
                c+=(n-r);
            }
            r++;
        }
    }
}
