class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        Character[] words = new Character[n];
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            words[i] = c;
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        Arrays.sort(words, (a, b) -> {
            if (!hm.get(a).equals(hm.get(b))) return hm.get(b) - hm.get(a);
            return a - b;
        });

        int result = 0;
        int increment = 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int freq = hm.get(words[i]);
            result += (freq * increment);

            count++;
            if (count == 8) {
                increment++;
                count = 0;
            }

            i += (freq - 1);
        }

        return result;
    }
}