public class Trie {

    static class Node {
        Node[] children;
        boolean endofword;


    public Node() {
        children = new Node[26]; 
        for(int i = 0; i < 26; i++){
            children[i] = null;
        }
        endofword = false;
    }
}
    static Node root = new Node();

    public static void Insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){ // Time Complexity is O(L); l mtlb length of the string.
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];

            // if(i == word.length() - 1){
                curr.endofword = true;
            // }


        }
    }


    public static boolean Search(String key){
        Node curr = root;
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            if(i == key.length() - 1 && curr.children[idx].endofword == false){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = {"the" , "a", "there", "teir", "any"};
        for(int i = 0; i < words.length; i++){
            Insert(words[i]);
        }

        System.out.println(Search("teir"));
        System.out.println(Search("thir"));
    }
}
