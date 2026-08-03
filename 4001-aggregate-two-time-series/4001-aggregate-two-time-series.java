class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> result = new ArrayList<>();
        int n1 = series1.length;
        int n2 = series2.length;

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < n1 && idx2 < n2) {
            if (series1[idx1][0] < series2[idx2][0]) {
                int nextVal = binarySearch(series2, n2, series1[idx1][0]);
                result.add(new ArrayList<>(
                        List.of(series1[idx1][0], series1[idx1][1] + nextVal)
                    )
                );
                idx1++;
            } else if (series1[idx1][0] > series2[idx2][0]) {
                int nextVal = binarySearch(series1, n1, series2[idx2][0]);
                result.add(new ArrayList<>(
                        List.of(series2[idx2][0], series2[idx2][1] + nextVal)
                    )
                );
                idx2++;
            } else {
                result.add(new ArrayList<>(
                        List.of(series1[idx1][0], series1[idx1][1] + series2[idx2][1])
                    )
                );
                idx1++;
                idx2++;
            }
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

    public int binarySearch(int[][] nums, int n, int target) {
        int low = 0;
        int high = n - 1;
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid][0] == target) return nums[mid][1];
            else if (nums[mid][0] > target) {
                result = nums[mid][1];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}