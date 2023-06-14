package edu.wat.tim.lab1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parent")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParentEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "parentValue")
    private String parentValue;

    @OneToMany(mappedBy = "parentEntity", cascade = CascadeType.ALL)
    private List<ChildEntity> childEntities = new ArrayList<>();

    public ParentEntity(String parentValue) {
        this.parentValue = parentValue;
    }



}
