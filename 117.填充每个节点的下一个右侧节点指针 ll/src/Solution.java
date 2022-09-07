/*
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
则将 next 指针设置为 NULL。

初始状态下，所有next 指针都被设置为 NULL。

输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，
以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。

 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//二叉树
class Solution {
    public Node connect(Node root) {
        //判断root和左子树是否为空，为空则直接返回，没有next，next可以视为下一层的代表*
        if (null == root)
            return root;

        //不为空则左子树下一个是右子树
        if (root.left!=null && root.right!=null)
            root.left.next = root.right;

        if(root.left!=null && root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null)
            root.right.next=getNext(root.next);

        connect(root.right);
        connect(root.left);

        return root;
    }

    public Node getNext(Node root){
        if(root==null) return null;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        if(root.next!=null) return getNext(root.next);
        return null;
    }
}