package arrays;

public class sorted_rotated {
     public boolean check(int[] nums) {
        int n = nums.length;
        int drop = 0; 
        for(int i = 0;i<n;i++){
            if(nums[i] <= (nums[(i+1)% n])){
                continue;
            }
            else{
                drop++;
            }
        }
        if (drop <=1) return true ;
       return false;        
    }
}
