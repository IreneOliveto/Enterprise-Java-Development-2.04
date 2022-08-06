import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person = new Person("Id", "Name Name", 20, "Software Developer");

    @Test
    public void whenAgeIsLessThanZero_shouldThrowNull() {
        assertThrows(IllegalArgumentException.class,()-> person.setAge(-3));
    }

    @Test
    public void whenAgeIsGreaterThanZero_shouldReturnAge() {
        assertDoesNotThrow(()-> person.setAge(20));
    }

    @Test
    public void equals_whenAllAttributesHaveTheSameValues_shouldReturnTrue() {
        Person person1 = new Person("Id", "Name name", 20, "Software Developer");
        Person person2 = new Person("Id", "Name name", 20, "Software Developer");

        boolean result = person1.equals(person2);
        assertEquals(result, true);
    }

    @Test
    public void equals_whenAllAttributesExceptIdHaveTheSameValues_shouldReturnTrue() {
        Person person1 = new Person("Id1", "Name name", 20, "Software Developer");
        Person person2 = new Person("Id2", "Name name", 20, "Software Developer");
        boolean result = person1.equals(person2);
        assertEquals(result, true);
    }

    @Test
    public void equals_whenAttributesAreDifferent_shouldReturnFalse() {
        Person person1 = new Person("Id1", "Name1 name", 21, "Software Developer");
        Person person2 = new Person("Id2", "Name2 name", 22, "Software Developer");

        boolean result = person1.equals(person2);
        assertEquals(result, false);

    }

    @Test
    public void whenWriteToFile_ShouldCreateNewFile() {
        Person person1 = new Person("Id1", "Name1 name", 21, "Software Developer");

        person1.writeToFile(person1);
    }



}