class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        genPara(n, 0, 0, "", ans);
        return ans;
    }
    public void genPara(int n, int countOpen, int countClose, String curr, List<String> ans) {
        if(curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }
        if(countOpen < n) {
            genPara(n, countOpen + 1, countClose, curr + "(", ans);
        }
        if(countClose < countOpen) {
            genPara(n, countOpen, countClose + 1, curr + ")", ans);
        }
    }
}