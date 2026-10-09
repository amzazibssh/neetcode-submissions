class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0,res, current, nums);
        return res;
    }

    public void backtrack(
                            int i,
                            List<List<Integer>> res,
                            List<Integer> current, 
                            int[] nums
                        ){
        if(i == nums.length){
            int sum = 0;
            res.add(new ArrayList<>(current));
            return;
        }
        backtrack(i + 1, res, current, nums);
        
        // [], [3], [2], [2], [2, 3], [2], [], [1],
        current.add(nums[i]);
        backtrack(i + 1, res, current, nums);
        current.remove(current.size() - 1);
        
    }
}
