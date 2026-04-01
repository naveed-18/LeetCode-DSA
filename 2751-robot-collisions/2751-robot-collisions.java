class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;   
        Arrays.sort(order, (a, b) -> positions[a] - positions[b]);

        Boolean[] alive = new Boolean[n];
        Arrays.fill(alive, true);

        Stack<Integer> st = new Stack<>();

        for (int idx : order) {
            if (directions.charAt(idx) == 'R') {
                st.push(idx);
            } else {
                while (!st.isEmpty()) {
                    int top = st.peek();

                    if (healths[top] < healths[idx]) {
                        alive[top] = false;
                        st.pop();
                        healths[idx]--;
                    } else if (healths[top] > healths[idx]) {
                        alive[idx] = false;
                        healths[top]--;
                        break;
                    } else {
                        alive[top] = false;
                        alive[idx] = false;
                        st.pop();
                        break;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (alive[i]) result.add(healths[i]);
        }

        return result;
    }
}