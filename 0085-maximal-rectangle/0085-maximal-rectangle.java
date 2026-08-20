class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] nums = new int[n][m];

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (matrix[i][j] - '0');
                if (matrix[i][j] == '0') sum = 0;
                nums[i][j] = sum;
            }
        }

        int largestRectangle = Integer.MIN_VALUE;
        for (int[] row : nums) {
            largestRectangle = Math.max(largestRectangle, largestRectangleArea(row));
        }

        return largestRectangle;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int index = st.pop();
                int currSmall = i;
                int prevSmall = st.isEmpty() ? -1 : st.peek();
                int area = heights[index] * (currSmall - prevSmall - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int index = st.pop();
            int currSmall = n;
            int prevSmall = st.isEmpty() ? -1 : st.peek();
            int area = heights[index] * (currSmall - prevSmall - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}