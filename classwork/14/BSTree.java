import java.util.*;
import java.io.*;

public class BSTree {
  private TreeNode root;

  public BSTree (){
    root = null;
  }

  public void seed(){
    TreeNode t;

    t = new TreeNode(10);
    root = t;
    t = new TreeNode(5);
    root.setLeft(t);
    t = new TreeNode(20);
    root.setRight(t);

    root.getLeft().setRight( new TreeNode(8));

    t = new TreeNode(15);
    root.getRight().setLeft(t);

    t = new TreeNode(22);
    root.getRight().setRight(t);

  }

  public int search (int key){
    TreeNode curr = root;

    while (curr != null){
      if (curr.getData() == key){
        return curr.getData();
      } else if (key < curr.getData()){
        curr = curr.getLeft();
      } else {
        curr = curr.getRight();
      }
    }
    throw new NullPointerException();
  }

  public void insert (TreeNode t){

  }

  public void insert (int data){
    TreeNode newNode = new TreeNode (data);

    if (root == null){
      root = newNode;
    }

    TreeNode curr = root;
    TreeNode prev;

    while (curr != null){
      if(data == curr.getData()){
        // make some update to Node here.
        return;
      } else if (data < curr.getData()){
        prev = curr;
        curr = curr.getLeft();
      } else {
        prev = curr;
        curr = curr.getRight();
      }

      if (data < prev.getData()){
        prev.setLeft(newNode);
      } else {
        prev.setRight(newNode);
      }
    }
  }
}
