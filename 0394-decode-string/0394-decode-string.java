class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder currS = new StringBuilder();
                StringBuilder currN = new StringBuilder();

                while (st.peek() != '[') currS.append(st.pop());
                String currString = currS.reverse().toString();

                st.pop();

                while (!st.isEmpty() &&
                    st.peek() != '[' && st.peek() != ']' &&
                    !('a' <= st.peek() && st.peek() <= 'z')) {

                    currN.append(st.pop());
                }
                int freq = Integer.parseInt(currN.reverse().toString());

                for (int i = 0; i < freq; i++) {
                    for (char letter : currString.toCharArray()) st.push(letter);
                }
            } else {
                st.push(c);
            } 
        }

        for (char c : st) result.append(c);
        return result.toString();
    }
}