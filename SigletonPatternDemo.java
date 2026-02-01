class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject() {}

    public static SingleObject getInstance() {
        return instance;
    }
    
    public void message() {
        System.out.println("Writing a message");
    }
}

public class SigletonPatternDemo {
    public static void main(String[] args) {
        //SingleObject obj = new SingleObject(); // Error

        SingleObject object = SingleObject.getInstance();
        object.message();
        
    }
}
