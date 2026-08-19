class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, boolean[]> hm = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0], col = seat[1];
            if (!hm.containsKey (row)) hm.put(row, new boolean[11]);
            hm.get(row)[col] = true;;
        }

        int maxAllocation = 0;
        int rowCount = hm.size();
        for (int row : hm.keySet()) {
            maxAllocation += allocate (row, hm);
        }

        int remainingRows = n - rowCount;
        maxAllocation += 2 * remainingRows;

        return maxAllocation;
    }

    public int allocate (int row, HashMap<Integer, boolean[]> hm) {
        int result = 0;
        boolean[] column = hm.get(row);

        int currConsSeats = 0;
        for (int col = 2; col <= 5; col++) {
            if (!column[col]) {
                currConsSeats++;
                column[col] = true;
            } else {
                break;
            }
        }
        if (currConsSeats == 4) result++;

        currConsSeats = 0;
        for (int col = 4; col <= 7; col++) {
            if (!column[col]) {
                currConsSeats++;
                column[col] = true;
            } else {
                break;
            }
        }
        if (currConsSeats == 4) result++;
        
        currConsSeats = 0;
        for (int col = 6; col <= 9; col++) {
            if (!column[col]) {
                currConsSeats++;
                column[col] = true;
            } else {
                break;
            }
        }
        if (currConsSeats == 4) result++;

        return result;
    } 
}