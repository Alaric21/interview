package com.tchuenkam.interview.repositories;

import com.tchuenkam.interview.entities.CollectionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionItem, Long> {
}
