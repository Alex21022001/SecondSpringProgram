package second.spring.program.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import second.spring.program.models.Person;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void test() {
        Session session = entityManager.unwrap(Session.class);
        List<Person> people = session.createQuery("SELECT p from  Person p LEFT JOIN FETCH p.item").getResultList();
        //FETCH - мы получаем в переменную Person все его Item.
        for (Person person : people) {
            System.out.println(person.getItem());
        }
    }
}
