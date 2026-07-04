class Solution {
    class Pair {
        int num, index;
        Pair (int num, int index) {
            this.num = num;
            this.index = index;
        } 
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        Pair[] numsPair = new Pair[n];
        for (int i = 0; i < n; i++) {
            numsPair[i] = new Pair(nums[i], i);
        }

        int[] res = new int[n];
        mergeSort(0, n - 1, numsPair, res);

        List<Integer> result = new ArrayList<>();
        for (int r : res) result.add(r);

        return result;
    } 

    public void mergeSort(int low, int high, Pair[] numsPair, int[] res) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(low, mid, numsPair, res);
        mergeSort(mid + 1, high, numsPair, res);
        countSmallNumbers(low, mid, high, numsPair, res);

        merge(low, mid, high, numsPair);
    }

    public void countSmallNumbers(int low, int mid, int high, 
        Pair[] numsPair, int[] res) {

        int j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && numsPair[i].num > numsPair[j].num) j++;

            res[numsPair[i].index] += (j - (mid + 1));
        }
    }

    public void merge(int low, int mid, int high, Pair[] numsPair) {
        Pair[] temp = new Pair[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (numsPair[i].num <= numsPair[j].num) {
                temp[k++] = numsPair[i++];
            } else {
                temp[k++] = numsPair[j++];
            }
        }

        while (i <= mid) temp[k++] = numsPair[i++];

        while (j <= high) temp[k++] = numsPair[j++];

        for (int idx = low; idx <= high; idx++) {
            numsPair[idx] = temp[idx - low];
        }
    }
}