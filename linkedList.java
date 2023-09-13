package DataStructure;

public class linkedList {


    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //addition at first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //addituon at last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }


        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    //print linklist
    public void printList() {
        if (head == null) {
            System.out.println("the list is empty");
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }
//addition in any position
    public void addition(int index, int data) {
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
// remove last node
    public int RemoveLast() {
        if (size == 0) {
            System.out.println("the list is empty!");
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        prev = tail;
        size--;
        return val;
    }
//searching element 
    public int linSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (key == temp.data) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
//searching element using recursion
    public int helper(int key, Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(key, head.next);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int Research(int key) {
        return helper(key, head);
    }
//reverse a linklist
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void removeNthNode(int n){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
head=head.next;
return;
        }
        int i=1;
        int iTofind=sz-n;
        Node prev=head;
        while(i<iTofind){
prev=prev.next;
i++;
        }
        prev.next=prev.next.next;
        return;

    }


    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(5);
        list.addition(2, 3);
//list.RemoveLast();
        

//System.out.println(list.size);
      //  list.reverse();
        list.printList();
        list.removeNthNode(3);
list.printList();
        //System.out.println(list.Research(3)); 
    }
}
    

