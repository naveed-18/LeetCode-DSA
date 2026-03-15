class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0,nums,new ArrayList<>(),ans);
        return ans;  
    }
    public void backTrack(int index, int[] nums,List<Integer> curr,List<List<Integer>>ans){
        
        ans.add(new ArrayList<>(curr));
        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            backTrack(i+1,nums,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}