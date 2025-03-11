package TH1;

public class Complex {
    private double real;
    private double imag;


    public Complex() {
    }

    // Constructor với một tham số thực
    public Complex(double real) {
        this.real = real;
    }


    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }


    public Complex(Complex c) {
        this.real = c.real;
        this.imag = c.imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }


    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }


    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }


    public Complex multiply(Complex other) {
        double resultReal = this.real * other.real - this.imag * other.imag;
        double resultImag = this.real * other.imag + this.imag * other.real;
        return new Complex(resultReal, resultImag);
    }

    // Chia hai số phức
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double resultReal = (this.real * other.real + this.imag * other.imag) / denominator;
        double resultImag = (this.imag * other.real - this.real * other.imag) / denominator;
        return new Complex(resultReal, resultImag);
    }

    // Phương thức toString để hiển thị số phức
    @Override
    public String toString() {
        if (imag == 0) return real + "";
        if (real == 0) return imag + "i";
        if (imag < 0) return real + " - " + (-imag) + "i";
        return real + " + " + imag + "i";
    }
}
