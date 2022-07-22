package hw10;

import GameOfLife.model.GameTree;

/**
 * This collection class maintains a set of values in their natural order as
 * defined by compareTo. The only type that can be stored in this collection
 * must implement interface Comparable<T>. You must use a Binary Search tree as
 * the data structure so add, contains, and remove all run O(log n).
 * 
 * @author Rick Mercer and Ivan Akinfiev
 *
 * 
 * @param <T>
 *          The type argument when constructed can be any type that implements
 *          Comparable or another interface that extends Comparable
 * 
 *          This class avoids ordered sets of elements that are not
 *          Comparable<T>
 */



public class OrderedSet<T extends Comparable<T>> { // New thing, do not change!


  private class TreeNode {

    // Instance variables
    private T data;
    private TreeNode left;
    private TreeNode right;

    TreeNode(T theData) {
      data = theData;
      left = null;
      right = null;
    }



  }

  private TreeNode root;
  private int n;

  // Create an empty OrderedSet
  public OrderedSet() {
    root = null;
    n = 0;
  }

  // Insert element into this OrderedSet and return true keeping the BST ordering
  // property. If element exists, do not change this OrderedSet, return false.
  // A set must have unique elements.
  // add(T) must run O(log n)
  public boolean add(T element) {
    if (root == null) {
      root = new TreeNode(element);
      n++;
    } else {
      TreeNode cur = root;
      TreeNode prev = root;
      while (cur != null) {
        prev = cur;
        if (element.compareTo(cur.data) < 0) {
          cur = cur.left;
        } else if (element.compareTo(cur.data) > 0) {
          cur = cur.right;
        } else {
          return false;
        }
      }
      if (element.compareTo(prev.data) < 0) {
        prev.left = new TreeNode(element);
        n++;
      } else {
        prev.right = new TreeNode(element);
        n++;
      }
    }
    return true;

  }

  // The number of elements in this OrderedSet, which should be 0 when first
  // size() Must run O(1). Use n, do not do a traversal.
  public int size() {
    return n;
  }

  private String bstInOrder(TreeNode root) {
    String str = "";
    if (root == null) {
      return "";
    }
    str += bstInOrder(root.left);
    str += root.data + " ";
    str += bstInOrder(root.right);
    return str;
  }

  // Return one string that concatenates all elements in this OrderedSet as
  // they are visited in order. Elements are separated by spaces as in "1 4 9"
  // from this OrderedSet.
  // ___ 4
  // _ / _ \
  // _1 ___ 9
  // This algorithm must run O(n).  You have to visit every TreeNode in the BST.
  public String toStringInorder() {
    return bstInOrder(root);
  }





  public boolean contains(T search) {
    if (root == null) {
      return false;
    }
    TreeNode cur = root;
    while (cur != null) {

      if (cur.data.compareTo(search) == 0) {
        return true;
      } else if (cur.data.compareTo(search) > 0) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }

    return false;

  }

  // Remove el from this OrderedSet leaving the Binary Search Tree with its
  // ordering property and return true. If el is not in this OrderedSet, return
  // false. This is a very challenging algorithm. Start with the simplest cases.
  //
  // 1. The Ordered set is empty (size() = 0)
  // 2. One element
  // 3. A tree with no left subtree from the root
  // 4. Several tests when the node to be removed has no left child
  // 5. The TreeNode to be removed has both a left and right nonEmpty BST
  //
  // remove(T) must run O(log n)
  //
  public boolean remove(T el) {
    boolean triggerLeft = false;
    if (size() == 0) {
      return false;
    }
    else if (size() == 1 && contains(el)){
      root = null;
      return true;
    }
    else if (!contains(el)){
      return false;
    }
    else if(root.data.compareTo(el) == 0 && root.left == null && root.right  != null){
        root = root.right;
        n--;
        return true;
    }

    else {

      TreeNode cur = root;
      TreeNode prev = null;
      while (cur != null) {
        if (cur.data.compareTo(el) == 0){
          break;
        }
        prev = cur;
        if (el.compareTo(cur.data) < 0){
          cur = cur.left;
          triggerLeft =true;
        }
        else {
          cur = cur.right;
          triggerLeft = false;
        }
      }
      if (cur.left == null && cur.right == null && triggerLeft){
        prev.left = null;
        n--;
        return true;
      }
      else if (cur.left == null && cur.right == null){
        prev.right = null;
        n--;
        return true;

      }
      else if (cur.left == null){
        if (triggerLeft){
          prev.left = cur.right;
          n--;
          return true;
        }else {
          prev.right = cur.right;
          n--;
          return true;
        }
      }
      else {
        //
        TreeNode maxNode = cur.left;
        //if (cur.left.right == null){
        //  maxNode = cur;
        //}

        TreeNode prevMaxNode = maxNode;
        while (maxNode.right != null){
          prevMaxNode = maxNode;
          maxNode = maxNode.right;
        }
        cur.data = maxNode.data;

        if (maxNode.left == null){
          prevMaxNode.right = null;
          n--;
          return true;
        }
        else {
          prevMaxNode.right = maxNode.left;
          n--;
          return true;
        }
      }
    }
  }


}