package edu.wat.tim.lab1.repository;

import edu.wat.tim.lab1.model.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildEntityRepository extends JpaRepository<ChildEntity, Long> {
}
