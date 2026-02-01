// Interface Shape class
interface Shape {
    public void draw();
}

// Circle class
class Circle implements Shape {
    public void draw(){
        System.out.println("Drawing a Circle");
    }
}

// Square class
class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Sqaure");
    }
}

// RoundedCircle class
class RoundedCircle implements Shape {
    public void draw() {
        System.out.println("Drawing a RoundedCircle");
    }
}

// RoundedSquare class
class RoundedSquare implements Shape {
    public void draw() {
        System.out.println("Drawing a RoundedSquare");
    }
}

// AbstractFactory class
abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
}

// ShapeFactory class
class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        else if(shapeType.equalsIgnoreCase("SQUARE")) return new Square();

        return null;
    }
}

// RoundedShapeFactory
class RoundedShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("ROUNDEDCIRCLE")) return new RoundedCircle();
        else if(shapeType.equalsIgnoreCase("ROUNDEDSQUARE")) return new RoundedSquare();

        return null;
    }
}

// FactoryProducer class
class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if(rounded) return new RoundedShapeFactory();

        return new ShapeFactory();
    }
}

// AbstractShapeFactoryDemo class
public class AbstractShapeFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(false);

        Shape shape1 = shapeFactory1.getShape("CIRCLE");
        shape1.draw();
         Shape shape2 = shapeFactory1.getShape("SQUARE");
        shape2.draw();
        

        AbstractFactory shapeFactory2 = FactoryProducer.getFactory(true);
        Shape shape3 = shapeFactory2.getShape("ROUNDEDCIRCLE");
        shape3.draw();
         Shape shape4 = shapeFactory2.getShape("ROUNDEDSQUARE");
        shape4.draw();




        
        
    }
}
