package second.spring.program.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import second.spring.program.models.Item;
import second.spring.program.models.Person;
import second.spring.program.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemsService {
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }


    public List<Item> findByOwner(Person owner){
        return itemsRepository.findByOwner(owner);
    }

    public List<Item> findAll() {
        return itemsRepository.findAll();
    }
}
