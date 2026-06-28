import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        // 1. Start from n-2 to avoid ArrayIndexOutOfBoundsException
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        // 2. If no pivot is found, reverse the entire array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 3. Find the first element from the right greater than nums[pivot]
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot); // Pass array reference and indices
                break;
            }
        }

        // 4. Reverse everything to the right of the pivot
        reverse(nums, pivot + 1, n - 1);
    }

    // Helper method to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a portion of the array in-place
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
