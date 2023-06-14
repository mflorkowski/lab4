package edu.wat.tim.lab1.repository;

import edu.wat.tim.lab1.model.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildEntityRepository extends JpaRepository<ChildEntity, Long> {
}
