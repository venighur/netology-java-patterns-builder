import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
        this.address = null;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = null;
    }

    public boolean hasAge() {
        return age.isPresent();
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        age = OptionalInt.of(age.getAsInt() + 1);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (возраст - " + age.getAsInt() + ", адрес - " + address + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.hashCode(), surname.hashCode(), age, address.hashCode());
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        return child.setSurname(surname).setAddress(address).setAge(0);
    }
}
