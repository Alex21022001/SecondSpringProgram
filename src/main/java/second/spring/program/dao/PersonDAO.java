package second.spring.program.dao;

import org.springframework.stereotype.Component;
import second.spring.program.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(PEOPLE_COUNT++, "Tom","polka@gmail.com",21));
        people.add(new Person(PEOPLE_COUNT++, "Kot","lolka@gmail.com",12));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person updatePerson = show(id);
        updatePerson.setName(person.getName());
        updatePerson.setAge(person.getAge());
        updatePerson.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(x-> x.getId()==id);
    }

    public void cutEggs(int id) {
     Person persForCut =  people.stream().filter(x->x.getId()==id).findAny().orElse(null);
     persForCut.setName(persForCut.getName()+"(Without EGGS)");
    }
}
