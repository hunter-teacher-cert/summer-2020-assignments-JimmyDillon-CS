import java.util.*;
import java.io.*;

public class TreeNode {

  private int data;
  private TreeNode left;
  private TreeNode right;

  public TreeNode (){
    data = 0;
    left = null;
    right = null;
  }

  public TreeNode (int data){
    this.data = data;
    left = null;
    right = null;
  }

  public int get (){
    return data;
  }

  public void set (int data){
    this.data = data;
  }

}
