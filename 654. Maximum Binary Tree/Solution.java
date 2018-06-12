class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        /*
        Use recursive function buildUp to find the maxTree. Find the max value in array nums, 
        and then find the max for the left part of that max values, and the max for the right part, recursively.
        Then return the tree. 
        这道题就是用递归的思想，先找到数组的最大值，然后分别找这个最大值左侧和右侧的最大值。然后这些最大值作为树里的节点，直到递归结束。
        */
        return buildUp(nums, 0, nums.length - 1);        
    }
    
    public TreeNode buildUp(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        int max_id = -1;
        if (start > end){
            return null;
        }
        for(int i = start; i<= end; i++){
            if(nums[i] > max){
                max = nums[i];
                max_id = i;
            }
            max = Math.max(max, nums[i]);
        }
        TreeNode head = new TreeNode(max);
        head.left = buildUp(nums, start, max_id - 1);
        head.right = buildUp(nums, max_id + 1, end);
        return head;
    }
}