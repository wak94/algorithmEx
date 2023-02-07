package Day_2023_2_3;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author wak
 */
public class BinaryTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        preOrder(root);
        preOrder1(root);
        inOrder(root);
        inOrder1(root);
        postOrder(root);
        postOrder1(root);
        levelOrder(root);
    }

    /**
     * 二叉树前序遍历
     *
     * @param root 根节点
     */
    public void preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            result.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
        System.out.println(result);
    }

    public void preOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.peek();
            s.pop();
            if (node != null) {
                if (node.right != null) {
                    s.push(node.right);
                }
                if (node.left != null) {
                    s.push(node.left);
                }
                s.push(node);
                s.push(null);
            } else {
                //先把空节点弹出
                TreeNode tmp = s.pop();
                result.add(tmp.val);
            }
        }
        System.out.println(result);
    }

    public List<Integer> preOrderN(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.peek();
            s.pop();
            if (node != null) {
                if (node.children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        s.push(node.children.get(i));
                    }
                }
                s.push(node);
                s.push(null);
            } else {
                Node tmp = s.pop();
                result.add(tmp.val);
            }
        }

        return result;
    }

    /**
     * 二叉树中序遍历
     *
     * @param root 根节点
     */
    public void inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        //只要不空就一直遍历左节点并加入s，一旦为空，pop出栈顶元素，并遍历其右节点
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = s.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        System.out.println(result);
    }

    public void inOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.peek();
            if (node != null) {
                s.pop();
                if (node.right != null) {
                    s.push(node.right);
                }
                s.push(node);
                s.push(null);
                if (node.left != null) {
                    s.push(node.left);
                }
            } else {
                //先把空节点弹出
                s.pop();
                TreeNode tmp = s.pop();
                result.add(tmp.val);
            }
        }
        System.out.println(result);
    }

    public void postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            result.add(node.val);
            if (node.left != null) {
                s.push(node.left);
            }
            if (node.right != null) {
                s.push(node.right);
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }

    public void postOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.peek();
            if (node != null) {
                s.pop();
                s.push(node);
                s.push(null);
                if (node.right != null) {
                    s.push(node.right);
                }
                if (node.left != null) {
                    s.push(node.left);
                }
            } else {
                //先把空节点弹出
                s.pop();
                TreeNode tmp = s.pop();
                result.add(tmp.val);
            }
        }
        System.out.println(result);
    }

    public void levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }   
        q.add(root);
        q.add(null);
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.peek();
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                q.pop();
            } else {
                System.out.println(list);
                result.add(list);
                list = new ArrayList<>();
                q.pop();
                if (q.size() == 0) {
                    break;
                }
                q.add(null);
            }
        }
        System.out.println(result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}