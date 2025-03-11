package TH1;
public class ComplexTest {
    public static void main(String[] args) {
        // Test các constructor
        Complex c1 = new Complex();              // 0
        Complex c2 = new Complex(3.0);          // 3
        Complex c3 = new Complex(1.5, 2.5);     // 1.5 + 2.5i
        Complex c4 = new Complex(c3);           // sao chép c3

        // In ra để kiểm tra
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);

        // Test các phép toán
        Complex a = new Complex(3, 4);    // 3 + 4i
        Complex b = new Complex(1, 2);    // 1 + 2i

        System.out.println("\na = " + a);
        System.out.println("b = " + b);

        // Test cộng
        Complex sum = a.add(b);
        System.out.println("a + b = " + sum);

        // Test trừ
        Complex diff = a.subtract(b);
        System.out.println("a - b = " + diff);

        // Test nhân
        Complex product = a.multiply(b);
        System.out.println("a * b = " + product);

        // Test chia
        Complex quotient = a.divide(b);
        System.out.println("a / b = " + quotient);

        // Test getter và setter
        Complex c5 = new Complex();
        c5.setReal(5.0);
        c5.setImag(-3.0);
        System.out.println("\nAfter setting real = 5 and imag = -3: " + c5);
        System.out.println("Real part: " + c5.getReal());
        System.out.println("Imaginary part: " + c5.getImag());
    }
}