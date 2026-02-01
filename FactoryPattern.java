// interface Shape class
interface Shape {
    public void draw();
}

// Circle class
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Square class
class Square implements Shape {
    public void draw() {
        System.out.println("Drtawing a Square");
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
public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
        Shape shape1 = shapeFactory.getShape("SQUARE");
        shape1.draw();
        
    }
    
}
