class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> result = new ArrayList<>();
        int n1 = series1.length;
        int n2 = series2.length;

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < n1 && idx2 < n2) {
            int key = 0, value = series1[idx1][1] + series2[idx2][1];
            if (series1[idx1][0] == series2[idx2][0]) {
                key = series1[idx1][0];
                idx1++;
                idx2++;
            } else if (series1[idx1][0] < series2[idx2][0]) {
                key = series1[idx1][0];
                idx1++;
            } else {
                key = series2[idx2][0];
                idx2++;
            }
             result.add(new ArrayList<>(
                    List.of(key, value)
                )
            );
        }

        while (idx1 < n1) {
            result.add(new ArrayList<>(
                    List.of(series1[idx1][0], series1[idx1][1])
                )
            );
            idx1++;
        }

        while (idx2 < n2) {
            result.add(new ArrayList<>(
                    List.of(series2[idx2][0], series2[idx2][1])
                )
            );
            idx2++;
        }

        return result;
    }
}