package edu.wat.tim.lab1.repository;

import edu.wat.tim.lab1.model.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentEntityRepository extends JpaRepository<ParentEntity, Long> {

    // Dostępne słowa kluczowe https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

}
