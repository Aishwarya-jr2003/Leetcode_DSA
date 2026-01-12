package arrays;

public class second_largest_elements {
      public int secondLargestElement(int[] nums) {
       

        int largest = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;
        boolean foundSecond = false;
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
