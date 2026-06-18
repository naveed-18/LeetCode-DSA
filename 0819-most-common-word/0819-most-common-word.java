class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for (String ban : banned) set.add(ban);

        String paraLower = paragraph.toLowerCase();
        String[] words = paraLower.split("[^a-z]+");

        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || set.contains(word)) continue;
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        int maxi = 0;
        String result = "";
        for (String key : hm.keySet()) {
            if (maxi < hm.get(key)) {
                maxi = hm.get(key);
                result = key;
            }
        }

        return result;
    }
}