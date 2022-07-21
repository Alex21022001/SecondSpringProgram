package second.spring.program.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import second.spring.program.models.Person;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class PersonDao {
    private final EntityManager entityManager;

    @Autowired
    public PersonDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void test() {
        Session session = entityManager.unwrap(Session.class);
        List<Person> people = session.createQuery("select p from Person p LEFT JOIN FETCH p.item").getResultList();
        // FETCH - мы говрим БД, что мы  не просто хотим посмотреть данные 2 таблиц , а и связать их к таблице Person.

        for (Person person : people){
            System.out.println(person.getItem());
        }
    }
}
