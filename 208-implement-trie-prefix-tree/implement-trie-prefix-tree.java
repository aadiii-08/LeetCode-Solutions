class Trie {
    class Node{
        Node[] children;
        boolean eow;
        public Node() {
            children = new Node[26];
            eow = false;
        }
    }
    
    Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            Node node = curr.children[idx];

            if(node == null){
                node = new Node();
            }

            if(i == word.length() - 1){
                node.eow = true;
            }

            curr.children[idx] = node;
            curr = node;
        }
    }

    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            Node node = curr.children[idx];

            if(node == null) return false;
            curr = node;
        }
        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            Node node = curr.children[idx];
            
            if(node == null) return false;

            curr = node;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */