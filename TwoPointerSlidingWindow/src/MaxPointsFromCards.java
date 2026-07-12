public class MaxPointsFromCards {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,1};

        int lsum=0, rsum=0, k=3;

        for(int i=0;i<k;i++){
            lsum+=arr[i];
        }

        int max=lsum;
        int rIndex=arr.length-1;

        for(int i=k-1;i>=0;i--){
            lsum-=arr[i];

            rsum+=arr[rIndex--];
            max=Math.max(max,lsum+rsum);
        }

        System.out.println(max);
    }
}
