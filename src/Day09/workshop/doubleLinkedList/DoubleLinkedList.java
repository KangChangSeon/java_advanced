package Day09.workshop.doubleLinkedList;

//양방향 링크드 리스트
//문제 아래 코드를 분석하여 데이터를 임의 노드 앞에 노드를 추가하는 메서드 추가하세요
// method name : insertToFront(frontNode , insertNode);
public class DoubleLinkedList<T> {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
    }

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    //head 로 부터 특정 노드를 찾는 메서드
    public T searchFromHead(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    //tail 로부터 특정 노드를 찾는 메서드
    public T searchFromTail(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public void insertToFront(int frontNode, int insertNode) {
        // 초기 설정 head = Node 1
        Node<T> target = head;
        while (target != null) {
            if (target.data.equals(frontNode)) {
                break;
            }
            target = target.next;
        }

        // 찾아봤는데 음슴
        if (target == null) {
            System.out.println(frontNode + " Node 가 없습니다.");
            return;
        }

        Node<T> newNode = new Node<>((T) (Integer) insertNode);

        // MyLinkedList.insertToFront(3, 2); 기준 target이 3, newNode가 2
        newNode.next = target;
        newNode.prev = target.prev;

        // 위치 설정 해주기
        if (target.prev != null) {
            target.prev.next = newNode;
        } else {
            head = newNode;
        }
        target.prev = newNode;
    }

    //강사님 코드
//    public boolean insertToFront(T existData, T addData) {
//        if (this.head == null) {
//            this.head = new Node<T>(addData);
//            this.tail = this.head;
//            return true;
//        } else if (this.head.data == existData) {
//            Node<T> newHead = new Node<T>(addData);
//            newHead.next = this.head;
//            this.head.next.prev = newHead;
//            this.head = newHead;
//            return true;
//        } else {
//            Node<T> node = this.head;
//            while (node != null) {
//                if (node.data == existData) {
//                    Node<T> nodePrev = node.prev;
//                    nodePrev.next = new Node<T>(addData);
//                    nodePrev.next.next = node;
//
//                    nodePrev.next.prev = nodePrev;
//                    node.prev = nodePrev.next;
//                    return true;
//                } else {
//                    node = node.next;
//                }
//            }
//            return false;
//        }

}

