package TH2;

import TH1.Complex;

public class Stack {
    Node top;
    int size;
    public Stack() {}
    public Stack(Node top) {
        this.top = top;
    }

    public void push(int item) {
        Node newNode = new Node(item);
        if (this.top == null) {
            this.top = newNode;
            return;
        }
        newNode.next = this.top;
        // giữ lại nút đỉnh
        this.top = newNode;
        // cập nhật nút đỉnh
        this.size++;
    }

    public int pop() {
        if (this.top == null) {
            return -1;
        }
        int topItem = this.top.item;
        //lấy giá trị top
        this.top = this.top.next;
        // cập nhật lại top node
        size--;
        // giảm kích thước stack
        return topItem;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public int numberOfElements() {
        return this.size;
    }
    public void display(){
        Node temp = this.top;
        while(temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
            // chuyển con trỏ đến node tiếp theo
        }
    }
    class Node{
        int item;
        Node next;
        public Node(int item) {
            this.item = item;
            next = null;
        }
        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

    }
}
