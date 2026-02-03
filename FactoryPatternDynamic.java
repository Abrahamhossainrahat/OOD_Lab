/// Here user input is possible.. I use in here also getter and setter method for taking input
// interface Shape class
interface Shape {
    public void draw();
}

// Circle class
class Circle implements Shape {
    private double radius;
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }

    public void draw() {
        double area = Math.PI * radius * radius;

        System.out.println("Area of Circle : " + area);
    }
}

// Square class
class Square implements Shape {
    private double a;
    
    public void setA(double a) {
        this.a = a;
    }

    public double getA(){
        return a;
    }

    public void draw() {
        double area = Math.pow(a, 2);
        System.out.println("Area of Square : " + area);
    }
}

// ShapeFactory class
class ShapeFactory {
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        else if(shapeType.equalsIgnoreCase("SQUARE")) return new Square();

        return null;
    }
}
public class FactoryPatternDynamic {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        ((Circle)shape1).setRadius(2);
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        // shape2.draw();
        ((Square)shape2).setA(5);
        shape2.draw();
        ((Square)shape2).setA(10);
        shape2.draw();
        
    }
    
}
