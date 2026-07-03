public class TreeNode1{
    public class TreeNode {
      int val;
      TreeNode right;
      TreeNode left;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static TreeNode sortedArrayToBST(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            TreeNode(nums[i], )
        }
        
    }


    public static void main(String[] args) {
        int nums[] = {-10,-3,0,3,9};
        sortedArrayToBST(nums);
    }
}