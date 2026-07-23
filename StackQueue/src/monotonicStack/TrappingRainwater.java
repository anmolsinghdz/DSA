package monotonicStack;

public class TrappingRainwater {
    public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        int n= height.length;

//        int prefixMax[]=new int[n];
//        int suffixMax[]=new int[n];
//
//        prefixMax[0]=height[0];
//        suffixMax[n-1]=height[n-1];
//        for(int i=1;i<n;i++){
//            prefixMax[i]=Math.max(prefixMax[i-1],height[i]);
//        }
//        for(int i=n-2;i>=0;i--){
//            suffixMax[i]=Math.max(suffixMax[i+1],height[i]);
//        }
//        int total=0;
//        for(int i=0;i<n;i++){
//            if(height[i]<prefixMax[i] && height[i]<suffixMax[i]){
//                total+=Math.min(prefixMax[i],suffixMax[i])-height[i];
//            }
//        }
//
//        System.out.println(total);

        int lmax=0, rmax=0, ans=0;
        int l=0, r=n-1;
        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            if(lmax<rmax){
                ans+=lmax-height[l];
                l++;
            }
            else{
                ans+=rmax-height[r];
                r--;
            }
        }

        System.out.println(ans);
    }
}
