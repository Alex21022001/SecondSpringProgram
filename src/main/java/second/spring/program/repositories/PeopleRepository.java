package second.spring.program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import second.spring.program.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {
    List<Person> findByEmail(String email);



    List<Person> findByName(String name);

    List<Person> findByNameStartingWith(String nameStartingWith);

    List<Person> findByNameOrEmail(String name, String email);


}
