/*
给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
如果存在，返回 true ；否则，返回 false 。

二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。

输入：root = [3,4,5,1,2], subRoot = [4,1,2]
输出：true

输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
输出：false
 */

//二叉树
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //空树
        if(isSameTree(root,subRoot)||subRoot==null)
            return true;
        if(root==null) return false;

        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        //到底了，返回true
        if(p==null&&q==null) return true;
        //其中一个没到底，false
        else if(p==null||q==null) return false;
        //其中有不一样的值，false
        else if(p.val!=q.val) return false;
        //递归
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}