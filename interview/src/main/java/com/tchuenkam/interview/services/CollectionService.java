package com.tchuenkam.interview.services;

import com.tchuenkam.interview.entities.CollectionItem;
import com.tchuenkam.interview.repositories.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {
    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public CollectionItem saveCollectionItem(CollectionItem collectionItem) {
        return collectionRepository.save(collectionItem);
    }

    public List<CollectionItem> getAllCollectionItem() {
        return collectionRepository.findAll();
    }

    public CollectionItem getCollectionItemById(Long id) {
        return collectionRepository.getById(id);
    }

    public void deleteCollectionItemById(Long id) {
         collectionRepository.deleteById(id);
    }

    public CollectionItem updateCollectionItemById(CollectionItem collectionItem, Long id) {
        Optional<CollectionItem> collection =   collectionRepository.findById(id);
        if(collection.isPresent()) {
            collection.get().setOwner(collectionItem.getOwner());
            collection.get().setRatio(collectionItem.getRatio());
            collection.get().setOwner(collectionItem.getSales());
            collection.get().setOwner(collectionItem.getSite());
            return collectionRepository.save(collection.get());
        } else {
            throw new NullPointerException("collection doesn't exist");
        }

    }
}
