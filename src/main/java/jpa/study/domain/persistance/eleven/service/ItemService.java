package jpa.study.domain.persistance.eleven.service;

import jpa.study.domain.persistance.eleven.domain.Item;
import jpa.study.domain.persistance.eleven.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository){
        this.repository = repository;
    }

    public void save(Item item) {
        repository.save(item);
    }

    public List<Item> findItems() {
        return repository.findAll();
    }

    public Item findOne(Long itemId) {
        return repository.findOne(itemId);
    }

}
