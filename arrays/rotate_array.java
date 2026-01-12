import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int k = 0;
        nums[k] = nums[0];
        for(int i=1;i<n;i++){
            
            if(nums[i] == nums[k]){
                continue;
            }
            else{
                k++;
                nums[k] = nums[i];
            }
           
        }
      return k+1;
        
    }
}