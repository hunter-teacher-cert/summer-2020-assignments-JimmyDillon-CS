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

  private void preorderTraverse (TreeNode current){
    if(current == null)
      return;

    // process the current Node
    System.out.print(current.getData()+", ");

    // recursively print out the left subtree
    preorderTraverse (current.getLeft());

    // recursively print out the right subtree
    preorderTraverse (current.getRight());
  }

  public void preorderTraverse(){
    preorderTraverse (root);
    System.out.println();
  }

  private void postorderTraverse (TreeNode current){
    if(current == null)
      return;

    // recursively print out the left subtree
    postorderTraverse (current.getLeft());

    // recursively print out the right subtree
    postorderTraverse(current.getRight());

    // process the current Node
    System.out.print(current.getData()+", ");
  }

  public void postorderTraverse(){
    postorderTraverse (root);
    System.out.println();
  }

  private void inorderTraverse (TreeNode current){
    if(current == null)
      return;

    // recursively print out the left subtree
    inorderTraverse (current.getLeft());

    // process the current Node
    System.out.print(current.getData()+", ");

    // recursively print out the right subtree
    inorderTraverse (current.getRight());
  }

  public void inorderTraverse(){
    inorderTraverse (root);
    System.out.println();
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


    // if tree is empty, newNode becomes the root
    if (root == null){
      root = newNode;
      return;
    }

    TreeNode curr = root;
    TreeNode prev = root;

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
    }

      if (data < prev.getData()){
        prev.setLeft(newNode);
        // System.out.println(data+" was added to the left");
      } else {
        prev.setRight(newNode);
        // System.out.println(data+" was added to the right");
      }

    }

    public void delete (int data){
      TreeNode curr = root;
      TreeNode prev = root;
      TreeNode deleteNode = root;

      while (curr != null){
        if (curr.getData() == data){
          System.out.println("found " + data);
          deleteNode = curr;
          // node to delete has no children
          if ((curr.getLeft() == null) && (curr.getRight() == null)){
            if(prev.getData() < data){
              prev.setRight(null);
              return;
            } else{
              prev.setLeft(null);
              return;
            }
          }
          // node to delete has one child
          else if ((curr.getLeft() == null) && (curr.getRight() != null)){
            if (prev.getData() < data){
              prev.setRight(curr.getRight());
              return;
            }else{
              prev.setLeft(curr.getRight());
              return;
            }
          }else if((curr.getLeft() != null) && (curr.getRight() == null)){
            if(prev.getData() < data){
              prev.setRight(curr.getLeft());
              return;
            } else {
              prev.setLeft(curr.getLeft());
              return;
            }
          }
          // node to delete has two children
          else {
              prev = curr;
              curr = curr.getLeft();
              while ((curr.getRight() != null) || (curr.getLeft() != null)){
                System.out.println("found neither children were null");
                if (curr.getRight() != null){
                  prev = curr;
                  curr = curr.getRight();
                }
                else{
                  prev = curr;
                  curr = curr.getLeft();
                }
              }

              // found the rightmost child of the delete node's left subtree.
              // need placeholder here to hold the value while we delete that value
              // but before we set the delete node to the placeholder value.
              int placeholder = curr.getData();
              System.out.println("found the placeholder: "+ placeholder);
              delete(curr.getData());
              deleteNode.setData(placeholder);
              return; // let's get out of here.
          }
        }
        // down the left subtree if no match
        else if (data < curr.getData()){
          prev = curr;
          curr = curr.getLeft();
        }
        // down the right subtree if no match
        else {
          prev = curr;
          curr = curr.getRight();
        }
      }
      // didn't find a node with that value;
      throw new NullPointerException();
    }

}
