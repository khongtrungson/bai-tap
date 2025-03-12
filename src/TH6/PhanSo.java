package TH6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PhanSo {
    private int tu;
    private int mau;

    public PhanSo(int tu, int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0");
        }
        this.tu = tu;
        this.mau = mau;
        toigian();
    }

    public PhanSo() {
        this.tu = 1;
        this.mau = 1;
    }

    private void toigian() {
        int gcd = ucln(tu, mau);
        // ước chung lớn nhất
        tu /= gcd;
        mau /= gcd;
        if (mau < 0) { // Đảm bảo mẫu số luôn dương
            tu = -tu;
            mau = -mau;
        }
    }

    private int ucln(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public final PhanSo add(final PhanSo a) {
        return new PhanSo(this.tu * a.mau + a.tu * this.mau, this.mau * a.mau);
    }

    public final PhanSo sub(final PhanSo a) {
        return new PhanSo(this.tu * a.mau - a.tu * this.mau, this.mau * a.mau);
    }

    public final PhanSo multiple(final PhanSo a) {
        return new PhanSo(this.tu * a.tu, this.mau * a.mau);
    }

    public final PhanSo divide(final PhanSo a) {
        if (a.mau == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }
        return new PhanSo(this.tu * a.mau, this.mau * a.tu);
    }

    public void input(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split("/");
                this.tu = Integer.parseInt(parts[0].trim());
                this.mau = Integer.parseInt(parts[1].trim());
                toigian();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Lỗi đọc tập tin: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }

    public static void main(String[] args) {
        PhanSo p1 = new PhanSo(2, 3);
        PhanSo p2 = new PhanSo(3, 4);

        System.out.println("Cộng: " + p1.add(p2));
        System.out.println("Trừ: " + p1.sub(p2));
        System.out.println("Nhân: " + p1.multiple(p2));
        System.out.println("Chia: " + p1.divide(p2));
    }
}
