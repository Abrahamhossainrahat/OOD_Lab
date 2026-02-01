// Item intercae class
import java.util.ArrayList;
import java.util.List;

interface Item {
    public String name();
    public Packing packing();
    public float price();
}

// Packing class
interface Packing {
    public String pack();
}

// Wrapper class
class Wrapper implements Packing {
    public String pack(){
        return "Wrapper";
    }
}

// Bottle class
class Bottle implements Packing {
    public String pack() {
        return "Bottle";
    }
}

//# Burger abstract class
abstract class Burger implements Item {
    public Packing packing(){
        return new Wrapper();
    }
    
    public abstract float price();
}

// Vegburger class 
class VegBurger extends Burger {
    public String name() {
        return "Veg-Burger";
    }

    public float price() {
        return 30.0f;
    }
}

// ChickenBurger class
class ChickenBurger extends Burger {
    public String name() {
        return "Chicken-Burger";
    }
    public float price() {
        return 40.0f;
    }
}

//# ColdDrink abstract class
abstract class ColdDrink implements Item {
    public Packing packing() {
        return new Bottle();
    }
    public abstract float price();
}

// Pepsi class 
class Pepsi extends ColdDrink {
    public String name() {
        return "Pepsi";
    }
    public float price(){
        return 35.0f;
    }
}

// Coke class 
class Coke extends ColdDrink {
    public String name() {
        return "Coke";
    }
    public float price() {
        return 40.0f;
    }
}

// Meal class 
class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }
    public float getCost() {
        float cost = 0.0f;
        for(Item item : items){
            cost += item.price();
        }
        return cost;
    }
    public void showItems() {
        for(Item item : items){
            System.out.println("Item : " + item.name() + ", Packing : " + item.packing().pack() + ", Price : " + item.price());
        }
    }
}

// MealBuilder class
class MealBuilder {
    public Meal PrepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());
        return meal;
    }
}

// BuilderPatternDemo (main) class
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        System.out.println("Vegetable Meal : ");
        Meal vegMeal = mealBuilder.PrepareVegMeal();
        vegMeal.showItems();
        System.out.println("Total Price : " + vegMeal.getCost());

        System.out.println("Non Vegetable Meal : ");
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.showItems();
        System.out.println("Total Price : " + nonVegMeal.getCost());
  
    }
}
