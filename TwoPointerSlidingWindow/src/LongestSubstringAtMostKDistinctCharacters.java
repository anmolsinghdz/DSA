import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringAtMostKDistinctCharacters {
    public static void main(String[] args) {

        String s="aaabbccd";
        int n=s.length(), maxlen=0, k=2;

        //Brute Force TC O(N^2)
//        Set<Character> set;
//
//        for(int i=0;i<n;i++){
//            set=new HashSet<>();
//            for(int j=i;j<n;j++){
//                char ch=s.charAt(j);
//                set.add(ch);
//                if(set.size()>k){
//                    break;
//                }
//                maxlen=Math.max(maxlen,j-i+1);
//            }
//        }

        //Better Approach O(N)
//        Map<Character,Integer> map=new HashMap<>();
//        int l=0, r=0;
//        while(r<n){
//            char ch=s.charAt(r);
//            map.put(ch,map.getOrDefault(ch,0)+1);
//            while(map.size()>k){
//                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
//                if(map.get(s.charAt(l))==0){
//                    map.remove(s.charAt(l));
//                }
//                l++;
//            }
//            maxlen=Math.max(maxlen,r-l+1);
//            r++;
//        }

        //Optimal Approach O(N)
        Map<Character,Integer> map=new HashMap<>();
        int l=0, r=0;
        while(r<n){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()>k){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if(map.size()<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }


        System.out.println(maxlen);
    }
}
