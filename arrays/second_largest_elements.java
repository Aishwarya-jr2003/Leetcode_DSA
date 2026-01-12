package arrays;

public class second_largest_elements {
      public int secondLargestElement(int[] nums) {
       
             int n = nums.length;
        if(n<2) return -1;
        int largest = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i]> largest){
                secondLargestElement = largest;
                largest = nums[i];
            }
            else if(nums[i]<largest){
                secondLargestElement = Math.max(secondLargestElement,nums[i]);
            }
        }
       if (secondLargestElement == Integer.MIN_VALUE)
          return -1;
          return secondLargestElement;
        // edge case for the larg = Integer.MIN_VALUE+1 and sl = Integer.MIN_VALUE;
    }

}
