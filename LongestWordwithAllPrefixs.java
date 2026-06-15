public class LongestWordwithAllPrefixs {
    static class Node{
        Node [] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    static Node root = new Node();

    public static void Insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            if(i == word.length() - 1){
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    public static boolean Search(String key){
        Node curr = root;
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            if(i == key.length() - 1 && curr.children[idx].eow == false){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static boolean WordBreakProblem(String key){
        if(key.length() == 0){ return true;}

        for (int i = 1; i <= key.length(); i++){
            String firstpart = key.substring(0, i);
            String secpart = key.substring(i);

            if(Search(firstpart) && WordBreakProblem(secpart)){
                return true;
            }
        }
        return false;
    }

    public static String ans = "";

    public static void longestword(Node root , StringBuilder temp){
        if(root == null){
            return;
        }

        for (int i = 0; i < 26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                temp.append((char)(i + 'a'));

                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestword(root.children[i], temp);

                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }


    public static void main(String[] args) {
        String words[] = {"a", "banana" , "ap" , "app" , "appl" , "apple" , "apply"};
        for(int i = 0; i < words.length; i++){
            Insert(words[i]);
        }
        longestword(root, new StringBuilder(""));
        System.out.println(ans);

    }
}

// HERE ALSO THE TIME COMPLEXITY IS O(L)----------------
