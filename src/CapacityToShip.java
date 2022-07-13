public class CapacityToShip {

    static boolean check(int [] arr, int n, int d, int mid){
        // initially there will atleast be one ship for the cargo, and assume the weight to be 0
        int count = 1;
        int weight = 0;

        // if one weight + next weight is smaller than or equals to mid then add next weight to mid
        // this will be the capacity of the ship
        for(int i= 0; i<n; i++){
        if(weight + arr[i]<=mid){
            weight +=  arr[i];
        }
        // else, do count ++ and choose the next weight as the weight.
        else{
            count++;
            weight = arr[i];
        }

    }
        // if the resultant days are less than or equals to the given limit, then true else false
        if(count<= d){
            return true;
        }else{
            return false;
        }
    }

        // capacity in d days, means the shipment should be divided in such a way that no ship delivers more
    public static int capacityToShipInDDays(int [] arr, int n, int d){
        // start with 0
        int low = 0;
        int high =0;
        // high will be the case when i deliver everything with one ship. and low will be the heaviest load in array.
        for(int i= 0; i<n; i++){
            high+= arr[i];
            low = Math.max(low, arr[i]);
        }
        //
        int ans =-1;
        // until high is smaller than low
        while(low<=high){
            int mid = (low + high)/2;
            // if mid can deliver it in d days, then try to search other mid on LHS
            if(check(arr, n, d, mid)){
                ans = mid;
                high =mid -1;
            }
            // else check the right side
            else{
                low = mid+1;
            }
        }return ans;

    }






    public static void main(String[] args) {

    }
}
