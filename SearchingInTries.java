package Tries;

public class SearchingInTries {
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
             //   System.out.print("Word Inserted" + " " +word);
            }
            currentNode = currentNode.children[index];
         }
    }

    static boolean search(String word){
        Node current = root;
        for(int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
           
            Node node  = current.children[index];
            if(node == null){
                return false;
            }
            if(i == word.length() - 1 && node.isTerminal == false){
                System.out.print("Word is doesN't Exist  ");
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
    public static void main(String[] args) {
          insert("ball");
          insert("dog");
          insert("apple");
          insert("apply");
          System.out.print(search("bal"));
    }
}
