package Day09.collection.tree.binarySearchTree;

public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        //CASE1 : Node가 하나도 없을때
        if (this.head == null) {
            this.head = new Node(data);
        } else { //CASE2 : Node가 하나 이상 들어가 있을때
            Node findNode = this.head;
            while (true) {
                //CASE2-1 :  현재 Node의 왼쪽에 노드가 들어가야 할때
                if (data <= findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }

                    //CASE2-2 :  현재 Node의 오른쪽에 Node가 들어가야 할때
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }

                }

            }

        }
        return true;
    }

    public Node searchNode(int data) {
        // 1. Node가 하나도 없을 때
        if (this.head == null) {
            return null;
            // 2. Node가 하나 이상일때
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
        }
        return null;
    }

    // 노드 삭제 boolean deleteNode(int data) : 팀 과제
    public boolean deleteNode(int data) {
        Node parent = null;
        Node current = head;

        while (current != null && current.value != data) {
            parent = current;
            if (data < current.value)
                current = current.left;
            else
                current = current.right;
        }

        if (current == null) {
            return false;
        }


        // 1: 자식이 X
        if (current.left == null && current.right == null) {
            if (parent == null) {
                head = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // 2. 자식이 하나
        else if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;
            if (parent == null) {
                head = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // 3. 자식이 둘
        else {
            Node parentMin = current;
            Node minNode = current.right;

            while (minNode.left != null) {
                parentMin = minNode;
                minNode = minNode.left;
            }

            current.value = minNode.value;

            if (parentMin.left == minNode) {
                parentMin.left = minNode.right;
            } else {
                parentMin.right = minNode.right;
            }
        }

        return true;
    }


}