package second.spring.program.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import second.spring.program.models.Person;
import second.spring.program.repositories.PeopleRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
//        return peopleRepository.findAll(PageRequest.of(1,4,Sort.by("name"))).getContent();
        return peopleRepository.findAll();
    }

    public Person findById(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        person.setCreatedAT(new Date());
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public Optional<Person> findByEmail(String email) {
        return peopleRepository.findByEmail(email).stream().findAny();
    }

    public List<Person> findByName(String name){
       return peopleRepository.findByName(name);
    }

    public List<Person> findByNameStartingWith(String startingName){
        return peopleRepository.findByNameStartingWith(startingName);
    }

    public List<Person> findByNameOrEmail(String name,String email){
        return peopleRepository.findByNameOrEmail(name,email);
    }

}
