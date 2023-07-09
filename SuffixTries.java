package Tries;

public class SuffixTries {
     static class Node{
        Node[] children ;
        boolean isTerminal;

        public Node(){
            children= new Node[26];
            for(int i= 0 ; i<26 ; i++){
                children[i] = null;
            }
            isTerminal = false;
        }
    }
    static Node root = new Node();

    static void insert (String word){
         Node currentNode = root;
         for(int i = 0 ; i< word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(currentNode.children[index] == null){
              currentNode.children[index] = new Node();
            }
            if(i == word.length() - 1){
                currentNode.children[index].isTerminal = true;
                System.out.println("Word Inserted" + " " +word);
            }
            currentNode = currentNode.children[index];
         }
    }
    static void insertSuffix(String word){
        int n = word.length();
       for(int i = 0 ; i < n ; i++){
            String suffix = word.substring(n-1-i);
            insert(suffix);
        }
    }
    public static void main(String[] args) {
        insertSuffix("brain");
        
    }
}
