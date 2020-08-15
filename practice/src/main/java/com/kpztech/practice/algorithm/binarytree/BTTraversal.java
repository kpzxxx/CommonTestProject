package com.kpztech.practice.algorithm.binarytree;

import org.junit.Test;

public class BTTraversal {

  @Test
  public void testPre() {
    TreeNode treeNode1 = new TreeNode();
    treeNode1.setData(3);
    TreeNode treeNode2 = new TreeNode();
    treeNode2.setData(3);
  }

  @Test
  // 通过前序和中序遍历重建二叉树
  public void testBuildFromPreAndMid() {
    int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
    int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
  }

  private TreeNode buildFromPreAndMid(int[] pre, int[] mid) {
    return buildFromPreAndMid(pre, 0, mid, 0, mid.length - 1);
  }

  private TreeNode buildFromPreAndMid(int[] pre, int preBegin, int[] mid, int midBegin, int midEnd) {
    int midRootLoc = 0;

    for(int i=midBegin; i<=midEnd; i++){
      if(mid[i] == pre[preBegin]){
        midRootLoc = i;
        break;
      }
    }
    TreeNode root = new TreeNode(mid[midRootLoc]);
    int leftLength = midRootLoc - midBegin;
    int rightLength = midEnd - midRootLoc;
//    if(leftLength > 0){
//      TreeNode left = buildFromPreAndMid(pre, preBegin + 1, mid, )
//    }

    return null;
  }
}
