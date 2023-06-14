package edu.wat.tim.lab1.service;

import edu.wat.tim.lab1.model.ChildEntity;
import edu.wat.tim.lab1.model.ParentEntity;
import edu.wat.tim.lab1.repository.ChildEntityRepository;
import edu.wat.tim.lab1.repository.ParentEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final ParentEntityRepository parentEntityRepository;
    private final ChildEntityRepository childEntityRepository;

    public ParentEntity createParentEntity(ParentEntity entity) {
        return parentEntityRepository.save(new ParentEntity(entity.getParentValue()));
    }

    public List<ParentEntity> getAllEntities() {
        return parentEntityRepository.findAll();
    }

    public ChildEntity addChildEntity(ChildEntity childEntity, Long parentId) {
        ParentEntity parentEntity = parentEntityRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono encji o id " + parentId));
        childEntity.setParentEntity(parentEntity);
        return childEntityRepository.save(childEntity);
    }

    public void deleteChildEntity(Long childId) {
        childEntityRepository.deleteById(childId);
    }

    public ParentEntity updateEntity(ParentEntity updatedEntity, Long id) {
        ParentEntity entity = parentEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono encji o id " + id));

        entity.setParentValue(updatedEntity.getParentValue());
        return parentEntityRepository.save(entity);
    }
}
