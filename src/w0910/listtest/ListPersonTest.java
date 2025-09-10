package w0910.listtest;

import java.util.ArrayList;

public class ListPersonTest {
    public static void main(String[] args) {
        Person person1 = new Person( "홍금보", 73, "남성");
        Person person2 = new Person("견자단", 62, "남성" );
        Person person3 = new Person("장원영", 21, "여성");

        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        PrintPerson printPerson = new PrintPerson();
        printPerson.print(persons);
    }
}
