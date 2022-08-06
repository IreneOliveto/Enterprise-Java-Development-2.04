import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Person {
    private String id;
    private String name;
    private int age;
    private String occupation;

    public Person(String id, String name, int age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Your age must be greater than 0");
        }
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setName(String name) {
        if(nameIsValid(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("This name is not valid");
        }
    }

    private boolean nameIsValid (String name) {
        return name != null && name.split(" ").length == 2;
    }

    public Person clone(Person person) {
        Person clone = new Person("0000", person.getName(), person.getAge(), person.getOccupation());
        return clone;
    }

    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) {
            return false;
        }
        Person person = (Person) object;
        return(person.getName().equals(this.name)
                && person.getAge() == this.age
                && person.getOccupation().equals(this.occupation));
    }

    public void writeToFile(Person person) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(person.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}
