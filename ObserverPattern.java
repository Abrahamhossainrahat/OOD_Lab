//# Observer abstract class

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

//# Subject class
class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
        notifyAllObserver();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}

// BinaryObserver class
class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update(){
        System.out.println("BinaryStyring : " + Integer.toBinaryString(subject.getState()));
    }
}

// OctalObserver class
class OctalObserver extends Observer {
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update() {
        System.out.println("OctalString : " + Integer.toOctalString(subject.getState()));
    }
}

// HexObserver class 
class HexObserver extends Observer {
    public HexObserver(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update(){
        System.out.println("HexString : " + Integer.toHexString(subject.getState()));
    }
}

// ObserverPattern main class
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        
        System.out.println("First changes : ");
        subject.setState(15);

        System.out.println("Second Changes : ");
        subject.setState(7);
        
    }
}
