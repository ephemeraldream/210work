package GameOfLife.model;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

// A model for the game of 20 questions. This type can be used to
// build a console based game of 20 questions or a GUI based game.
//
// @author Rick Mercer and Ivan Akinfiev
//
public class GameTree {

  // BinaryTreeNode inner class used to create new nodes in the GameTree.
  private class TreeNode {

    // Instance variables
    private String data;
    private TreeNode left;
    private TreeNode right;

    TreeNode(String theData) {
      data = theData;
      left = null;
      right = null;
    }

    // This 2nd constructor is needed in a few methods, like private build()
    TreeNode(String theData, TreeNode leftLink, TreeNode rightLink) {
      data = theData;
      left = leftLink;
      right = rightLink;
    }

  }

  // Instance variables
  private TreeNode root;
  private TreeNode currentNode;
  private Scanner scanner;
  private String fileName;


   private TreeNode build() {
     if(! scanner.hasNext())
       return null;

     String token = scanner.nextLine();

     if(token.charAt(token.length()-1) != '?')
       return new TreeNode(token);
     else {
       TreeNode leftSubtree = build();
       TreeNode rightSubtree = build();
         return new TreeNode (token, leftSubtree, rightSubtree);
     }
  }

  // Constructor needed to create the game. It should open the input 
  // file and call the recursive method build(). The String parameter
  // name is the name of the file from which we need to read the game 
  // questions and answers from.
  //
  public GameTree(String name) {
     fileName = name;
    try {
      scanner = new Scanner(new File(name));
    }
    catch (FileNotFoundException e){

    }
    root = build();
    currentNode = root; 
    scanner.close();
  }

  // Add a new question and answer to the currentNode. If the current 
  // node is referencing the answer "parrot", 
  //     theGame.add("Does it swim?", "duck"); 
  // should change the GameTree like this:
  //
  // ......Feathers?......................Feathers? 
  // ....../......\......................./......\ 
  // ..parrot....horse.........Does it swim?.....horse
  // ............................./......\
  // ..........................duck.....parrot 
  //
  // @param newQuestion: The question to add where the old answer was.
  // @param newAnswer: The new yes answer to the new question.
  public void add(String newQuestion, String newAnswer) {
     String currentString = currentNode.data;
     currentNode.left = new TreeNode(newAnswer);
     currentNode.right = new TreeNode(currentString);
     currentNode.data = newQuestion;
  }

  // Return true if getCurrent() is an answer rather than a question. Return false
  // if the current node is an internal node rather than a leaf that is an answer.
  public boolean foundAnswer() {
     if (currentNode.data.charAt(currentNode.data.length()-1) == '?') return false;
     else return true;
  }

  // Return the data for the current node, which could be a
  // question or an answer.
  public String getCurrent() {
    return currentNode.data;
  }

  // Ask the game to update the current node in the tree by
  // going left for Choice.yes or right for Choice.no 
  // Example code:
  //   theGame.playerSelected(Choice.Yes);
  //
  public void playerSelected(Choice yesOrNo) {
     if (yesOrNo == Choice.YES){
       currentNode = currentNode.left;
     }
     if (yesOrNo == Choice.NO){
       currentNode = currentNode.right;
     }
  }

  // Begin a game at the root of the tree. getCurrent should return the question
  // at the root of this GameTree.
  public void reStart() {
     currentNode = root;
  }

  // Overwrite the old file for this gameTree with the current state that may have
  // new questions added since the game started. Get all other method working first
  // Build this method last.
  public void saveGame() {
    // TODO: Complete this method
    // Hint: Call a private helper method with a root argument to do
    // a preorder traversal over the current state of this GameTree
    String outputFileName = fileName;
    FileWriter newWriter = null;
    try {
      newWriter = new FileWriter(outputFileName);
    }
    catch (IOException ioe){
      System.out.println("Can't create a File... " + ioe);
    }
    PrintWriter diskFile = new PrintWriter(newWriter);
    diskFile.print(preOrder());
    diskFile.close();


  }
  public String preOrder() {
    return preOrder(root).substring(0, preOrder(root).length());
  }
  private String preOrder(TreeNode t){
    if (t == null){
      return "";
    }
    else return t.data + "\n" + preOrder(t.left) + preOrder(t.right);
  }
  // Method used to print out a text version of the game file.
  @Override
  public String toString() {
    accumulate = "";
    toString(root, 0);
    return accumulate;
  }

  // Used in both toString methods to add strings like "- - - "
  private String accumulate; 
  
  private void toString(TreeNode node, int lvl) {
    if (node != null) {
      toString(node.right, lvl + 1);
      for (int i = 1; i <= lvl; i++) {
        accumulate += "-  ";
      }
      accumulate = accumulate + node.data + " \n";
      toString(node.left, lvl + 1);
    }

  }
}
