/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YOUSS
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private static int count;

    public LinkedList() {
    }

    public void addNode(int x) {
        count++;
        if (head == null) {
            Node t = new Node(x);
            head = t;
            tail = head;
            return;
        } else {
            Node t = new Node(x);
            tail.setNext(t);
            tail = t;
            return;
        }
    }

    public void addFirst(int x) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            Node t = new Node(x);
            t.setNext(head);
            head = t;
            count++;
        }
    }

    public void deleteNode(int x) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.getValue() == x) {
            head = head.getNext();
            count--;
            return;
        }
        Node q = head;
        Node p = q.getNext();
        while (p != null) {
            if (p.getValue() == x) {
                q.setNext(p.getNext());
                count--;
                return;
            }
            q = p;

            p = p.getNext();

        }

    }

    public void addBefore(int x, Node t) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.getValue() == x) {
            t.setNext(head);
            head = t;
            count++;
            return;
        }
        Node q = head;
        Node p = q.getNext();
        while (q != null) {
            if (p.getValue() == x) {
                q.setNext(t);
                t.setNext(p);
                return;
            }
            q = p;
            p = q.getNext();
        }
    }

    public void displayNode() {
        Node p = head;
        System.out.print("{");
        while (p != null) {
            System.out.print(p);
            p = p.getNext();
        }
        System.out.println("}");
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {

        return head == null;

    }

    public LinkedList mergeLists(LinkedList L2) {
        LinkedList L3 = new LinkedList();
        Node p1 = this.head;
        Node p2 = L2.getHead();
        while (p1 != null && p2 != null) {
            if (p1.getValue() < p2.getValue()) {
                L3.addNode(p1.getValue());
                p1 = p1.getNext();
            } else {
                L3.addNode(p2.getValue());
                p2 = p2.getNext();
            }
        }
        while (p1 != null) {
            L3.addNode(p1.getValue());
            p1 = p1.getNext();
        }
        while (p2 != null) {
            L3.addNode(p2.getValue());
            p2 = p2.getNext();
        }
        return L3;
    }

    public void sortList() {
        Node p = head;
        if (isEmpty()) {
            return;
        }
        while (p.getNext() != null) {
            Node q = p.getNext();
            while (q != null) {
                if (p.getValue() < q.getValue()) {
                    int t = p.getValue();
                    p.setValue(q.getValue());
                    q.setValue(t);
                }
                q = q.getNext();
            }
            p = p.getNext();
        }
    }

    public boolean equals(LinkedList L2) {
        if (this.count != L2.count) {
            return false;
        }
        Node h1 = this.head;
        Node h2 = L2.head;
        while (h1 != null) {
            if (h1.getValue() != h2.getValue()) {
                return false;
            }
            h1 = h1.getNext();
            h2 = h2.getNext();
        }
        return true;
    }

    public LinkedList copy() {
        LinkedList L2 = new LinkedList();
        Node p = this.head;
        while (p != null) {
            L2.addNode(p.getValue());
        }
        return L2;
    }

    public LinkedList reverse() {
        LinkedList L2 = new LinkedList();
        if (isEmpty()) {
            return L2;
        }
        Node p = this.head;
        while (p != null) {
            L2.addFirst(p.getValue());
        }
        return L2;
    }

    public boolean isPalindrome(LinkedList L1) {
        LinkedList L2 = L1.reverse();
        return (L1.equals(L2));
    }

    public static int getCount() {
        return count;
    }

    public LinkedList[] seperateLists(int x) {
        LinkedList[] L = new LinkedList[2];
        L[0] = new LinkedList();
        L[1] = new LinkedList();
        Node p = this.head;
        while (p != null) {
            if (p.getValue() != x) {
                p = p.getNext();
                return L;
            }
        }
        while (p != null) {
            if (p.getValue() != x) {
                L[0].addNode(p.getValue());
                p = p.getNext();
            } else {
                L[0].addNode(p.getValue());
                p = p.getNext();
                break;
            }
        }
        while (p != null) {
            L[1].addNode(p.getValue());
            p = p.getNext();
        }
        return L;
    }

    public LinkedList[] GenerateTwoLists() {
        LinkedList[] L = new LinkedList[2];
        L[0] = new LinkedList();
        L[1] = new LinkedList();
        Node p = head;
        while (p != null) {
            L[0].addFirst(p.getValue());
            p = p.getNext();
        }
        L[1] = L[0].copy();
        L[1].sortList();
        return L;
    }

    public boolean search(int x) {
        Node p = head;
        while (p != null) {
            if (p.getValue() != x) {
                p = p.getNext();
            }
            else 
                return true;
        }
        return false;

    }

    public void swap(int i, int j) {
        Node p = head;
        int a=1;
       Node node1 = null,node2=null;
        if (i == j) {
            return;
        }
        if (i > getCount() || j > getCount() || i < 1 || j < 1) {
            System.out.println("Wrong Index");
            return;
        }
        while (p != null) {
            if (a==i) {
                node1=p;
               
            }
            if (a==j) {
                node2=p;
            }
             p = p.getNext();
                a++;
        }
        int t = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(t);
        

    }

}
