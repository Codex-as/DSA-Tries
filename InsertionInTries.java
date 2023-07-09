package Tries;

public class InsertionInTries {
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
                System.out.print("Word Inserted" + " " +word);
            }
            currentNode = currentNode.children[index];
         }
    }
      public static void main(String[] args) {
        insert("apple");
      }
}
