import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    List<Person> personArrayList = new ArrayList<Person>();

    public Person findByName(String name) {
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getName().equals(name)) {
                return personArrayList.get(i);
            }
        }
        return null;
    }
}
