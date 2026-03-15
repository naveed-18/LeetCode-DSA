class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(1,k,n,new ArrayList<>(),ans);
        return ans;
    }
    public void backTrack(int num, int k , int n , ArrayList<Integer> curr, List<List<Integer>> ans){
        if(n==0 && curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(n<0){ 
            return;
        }
        for(int i = num;i<=9;i++){
            curr.add(i);
            backTrack(i+1,k,n-i,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}