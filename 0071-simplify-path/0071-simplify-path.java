class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] directories = path.split("/");

        for (String dir : directories) {
            if (dir.equals(".") || dir.isEmpty()) continue;
            else if (dir.equals("..")) {
                if (!st.isEmpty()) st.pop();
            }
            else st.push(dir);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            res.append("/").append(st.get(i));
        }

        if (res.length() == 0) return "/";

        return res.toString();
    }
}