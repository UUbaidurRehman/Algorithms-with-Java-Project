package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert method with duplicate check
    public void insert(int value) {
        if (search(value)) {
            throw new IllegalArgumentException("Node with value " + value + " already exists in the tree.");
        }
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Delete method with error handling
    public void delete(int value) {
        if (!search(value)) {
            throw new IllegalArgumentException("Node with value " + value + " does not exist in the tree.");
        }
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // Search method
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.value) {
            return true;
        }

        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    // Traversal methods returning results as a list
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }

    private void inorderRec(Node root, List<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.value);
            inorderRec(root.right, result);
        }
    }

    public List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        preorderRec(root, result);
        return result;
    }

    private void preorderRec(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.value);
            preorderRec(root.left, result);
            preorderRec(root.right, result);
        }
    }

    public List<Integer> postorder() {
        List<Integer> result = new ArrayList<>();
        postorderRec(root, result);
        return result;
    }

    private void postorderRec(Node root, List<Integer> result) {
        if (root != null) {
            postorderRec(root.left, result);
            postorderRec(root.right, result);
            result.add(root.value);
        }
    }
}
