package TH2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Shape {
    private int x,y; // tam toa do

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract double getArea() ;

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(0,0,2));
        shapes.add(new Ellipse(0,0,2,3));
        shapes.add(new Rectangle(0,0,2,3));
        shapes.add(new Circle(0,0,2));
        // hiển thị thông tin các đối tượng
        shapes.forEach(shape -> {
            System.out.println(shape);
        });
        // tổng diện tích
        double areaTotal = 0;
        for (Shape shape : shapes) {
            areaTotal += shape.getArea();
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("Square", 0);
        map.put("Ellipse", 0);
        map.put("Rectangle", 0);
        map.put("Circle", 0);

        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                map.put("Square", map.get("Square") + 1);
            } else if (shape instanceof Rectangle) {
                map.put("Rectangle", map.get("Rectangle") + 1);
            } else if (shape instanceof Circle) {
                map.put("Circle", map.get("Circle") + 1);
            } else if (shape instanceof Ellipse) {
                map.put("Ellipse", map.get("Ellipse") + 1);
            }
        }
        System.out.println(map);// thống kê số lần xuất hiện trong danh sách

    }

}
class Rectangle extends Shape {
    private double width,height;
    public Rectangle(int x, int y,int width,int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
class Square extends Shape {
    private double width;

    public Square(int x, int y, double width) {
        super(x, y);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width*width;
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                '}';
    }
}
class Ellipse extends Shape {
    private double semiMajorAxis,semiMinorAxis;

    public Ellipse(int x, int y, double semiMajorAxis, double semiMinorAxis) {
        super(x, y);
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiMajorAxis=" + semiMajorAxis +
                ", semiMinorAxis=" + semiMinorAxis +
                '}';
    }
}
class Circle extends Shape {
    private double radius;

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
