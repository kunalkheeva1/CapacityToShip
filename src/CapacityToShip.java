public class CapacityToShip {

    static boolean check(int [] arr, int n, int d, int mid){
        int count = 1;
        int weight = 0;
        for(int i= 0; i<n; i++){
        if(weight + arr[i]<=mid){
            weight +=  arr[i];
        }
        else{
            count++;
            weight = arr[i];
        }

    }
        if(count<= d){
            return true;
        }else{
            return false;
        }
    }


    public static int capacityToShipInDDays(int [] arr, int n, int d){
        int low = 0;
        int high =0;
        for(int i= 0; i<n; i++){
            high+= arr[i];
            low = Math.max(low, arr[i]);
        }

        int ans =-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(check(arr, n, d, mid)){
                ans = mid;
                high =mid -1;
            }
            else{
                low = mid+1;
            }
        }return ans;

    }






    public static void main(String[] args) {

    }
}
