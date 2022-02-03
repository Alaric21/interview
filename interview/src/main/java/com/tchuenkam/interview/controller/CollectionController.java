package com.tchuenkam.interview.controller;

import com.tchuenkam.interview.entities.CollectionItem;
import com.tchuenkam.interview.services.CollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }


    @PostMapping("/collection")
    public ResponseEntity<CollectionItem> saveCollection(@RequestBody CollectionItem collectionItem) {
        return new ResponseEntity<>(collectionService.saveCollectionItem(collectionItem), HttpStatus.OK);
    }

    @GetMapping("/collection-items")
    public ResponseEntity<List<CollectionItem>> getAllCollection() {
        return new ResponseEntity<>(collectionService.getAllCollectionItem(),HttpStatus.OK);
    }

    @GetMapping("/collection-items/{id}")
    public ResponseEntity<CollectionItem> getCollectionById(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(collectionService.getCollectionItemById(id),HttpStatus.OK);
    }
    @DeleteMapping("/collection-items/{id}")
    public void deleteCollectionById(@PathVariable("id") final Long id) {
       collectionService.deleteCollectionItemById(id);
    }

    @PutMapping("/collection-items/{id}")
    public ResponseEntity<CollectionItem> updateCollectionById(@RequestBody CollectionItem collectionItem, @PathVariable("id") final Long id) {
        return new ResponseEntity<>(collectionService.updateCollectionItemById(collectionItem,id),HttpStatus.OK);
    }
}
