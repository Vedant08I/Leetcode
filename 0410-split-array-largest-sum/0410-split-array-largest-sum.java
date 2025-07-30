class Solution {

    long[] maxAndSum(int[] arr){
        int max = arr[0];
        long sum = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }

            sum += arr[i];
        }

        return new long[]{max, sum};
    }

    int countSubarray(int arr[], long maxSum, int k){
        int sum  =0;
        int cntSubarray = 1;

        for(int i=0; i<arr.length; i++){
            if((sum +arr[i]) <= maxSum){
                sum += arr[i];
            }
            else{
                cntSubarray ++;

                if(cntSubarray > k){
                    return k+1;
                }
                sum = arr[i];
            }
        }

        return cntSubarray;
    }
    public int splitArray(int[] arr, int k) {
        long[] maxAndSum = maxAndSum(arr);
        int low = (int)maxAndSum[0];
        long high = maxAndSum[1];
        long mid = 0;

        while(low <= high){
            mid = low +(high-low)/2;
            int subarrays = countSubarray(arr, mid, k);

            if(subarrays <= k){
                high = mid-1;
            }
            else{
                low = (int)mid+1;
            }
        }

        return low;
    }
}