package TH2;

public class TestStack {
    public static void main(String[] args) {
        Stack initialStack = new Stack();// tạo stack rỗng
        System.out.println("empty stack"+ initialStack.isEmpty());
        initialStack.push(1); // 1
        initialStack.push(2); // 2 1
        initialStack.push(3); // 3 2 1

        initialStack.display(); //3,2,1
        System.out.println(initialStack.pop());// 3 giảm kích thước stack di 1
        initialStack.display(); //2 1
        initialStack.isEmpty(); // false
        initialStack.numberOfElements();// 2
    }
}
