class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        Node root = new Node();
        for (String product : products) insert(product, root);

        List<List<String>> result = new ArrayList<>();
        searchSuggestionsSystem(searchWord, root, result);

        return result;
    }

    public void searchSuggestionsSystem(String word, Node root, List<List<String>> result) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node == null || !node.contains(ch)) {
                node = null;
                result.add(new ArrayList<>());
            } else {
                node = node.get(ch);
                result.add(node.getSuggestions());
            }
        }
    }

    public void insert(String product, Node root) {
        Node node = root;
        for (char ch : product.toCharArray()) {
            if (!node.contains(ch)) node.put(ch, new Node());

            node = node.get(ch);
            List<String> suggestions = node.getSuggestions();
            if (suggestions.size() < 3) suggestions.add(product);
        }
    }
}

class Node {
    Node[] links;
    List<String> suggestions;

    public Node () {
        links = new Node[26];
        suggestions = new ArrayList<>();
    }

    boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    void put (char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    List<String> getSuggestions() {
        return suggestions;
    }
}