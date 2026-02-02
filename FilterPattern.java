import java.util.*;
//# Person class
class Person {
    private String name;
    private String gender;
    private String maritulStuatus;

    public Person(String name, String gender, String maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritulStuatus = maritalStatus;
    }

    public String getName() {
        return  name;
    }
    public String getGender() {
        return gender;
    }
    public String getMaritulStatus(){
        return maritulStuatus;
    }
}

// Criteria interface class
interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}

// CriteriaMale class
class CriteriaMale implements Criteria {
    public List<Person> meetCriteria(List<Person> persons){
        List<Person> malePersons = new ArrayList<Person>();
        for(Person person : persons){
            if(person.getGender().equalsIgnoreCase("MALE"))
                malePersons.add(person);
        }
        return malePersons;
    }
}


// CriteriaFemale class
class CriteriaFemale implements Criteria {
    public List<Person> meetCriteria(List<Person> persons){
        List<Person> femalePersons = new ArrayList<Person>();
        for(Person person : persons){
            if(person.getGender().equalsIgnoreCase("FEMALE"))
                femalePersons.add(person);
        }
        return femalePersons;
    }
}


// CriteriaSingle class
class CriteriaSingle implements Criteria {
    public List<Person> meetCriteria(List<Person> persons){
        List<Person> singlePersons = new ArrayList<Person>();
        for(Person person : persons){
            if(person.getMaritulStatus().equalsIgnoreCase("SINGLE"))
                singlePersons.add(person);
        }
        return singlePersons;
    }
}

// AndCriteria class
class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria anotherCriteria;

    public AndCriteria(Criteria criteria, Criteria anotherCriteria){
        this.criteria = criteria;
        this.anotherCriteria = anotherCriteria;
    }

    public List<Person> meetCriteria(List<Person> persons){
        List<Person> firstCriteriaPerosons = criteria.meetCriteria(persons);
        return anotherCriteria.meetCriteria(firstCriteriaPerosons);

    }
}

// OrCriteria class
class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria anotherCriteria;

    public OrCriteria(Criteria criteria, Criteria anotherCriteria){
        this.criteria = criteria;
        this.anotherCriteria = anotherCriteria;
    }
    public List<Person> meetCriteria(List<Person> persons){
        List<Person> firstCriteriaPerosons = criteria.meetCriteria(persons);
        List<Person> anotherCriteriaPersons = anotherCriteria.meetCriteria(persons);

        for(Person person : anotherCriteriaPersons){
            if(!firstCriteriaPerosons.contains(person)){
                firstCriteriaPerosons.add(person);
            }
        }
        return firstCriteriaPerosons;
    }
}

// FilterPattern main class
public class FilterPattern {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        
        persons.add(new Person("Rahim", "Male", "Single"));
        persons.add(new Person("Rahat", "Male", "Single"));
        persons.add(new Person("Kartik", "Male", "Married"));
        persons.add(new Person("Pranti", "Female", "Single"));
        persons.add(new Person("Rokeya", "Female", "Married"));
        persons.add(new Person("Abraham", "Male", "Married"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria maleSingle = new AndCriteria(male, single);
        Criteria femaleorSingle = new OrCriteria(female, single);

        System.out.println("Male Person : ");
        display(male.meetCriteria(persons));

        System.out.println("Female Person : ");
        display(female.meetCriteria(persons));

        System.out.println("Single Person : ");
        display(single.meetCriteria(persons));

        System.out.println("Male Single Person : ");
        display(maleSingle.meetCriteria(persons));

        System.out.println("Female or Single Person : ");
        display(femaleorSingle.meetCriteria(persons));
        
    }
    public static void display(List<Person> persons){
        for(Person person : persons){
            System.out.println("Name: "+person.getName() + ", Gender: "+ person.getGender() + ", MaritalStatus: " + person.getMaritulStatus());
        }
    }
}
