package Tries;

public class PrefixInTries {
     static class Node {
          Node[] children ;
           boolean isTerminal ;
     
     public Node(){
           children = new Node[26];
           for(int i = 0 ; i < 26 ; i++){
                children[i] = null;
           }
           isTerminal = false;
     }
    }
     static Node root = new Node();
    
    public static void insert(String word){
          Node current  = root ;
          for(int i = 0 ; i < word.length() ; i++){
               int index = word.charAt(i) - 'a';
               if(current.children[index] == null){
                      current.children[index] = new Node();
               }
               if(i == word.length() - 1){
                current.children[index].isTerminal = true;
                System.out.println("Word Inserted" + " " + word);
               }
               current = current.children[index];
          }
    }
    public static void insertPrefix(String word){
        for(int i = 0 ; i < word.length() ; i++){
             String Prefix = word.substring(0, i+1);
             insert(Prefix);
        }
    }
    public static void main(String[] args) {
        insertPrefix("brain");
    }

}
