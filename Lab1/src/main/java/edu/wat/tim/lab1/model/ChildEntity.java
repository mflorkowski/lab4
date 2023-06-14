package edu.wat.tim.lab1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="child")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChildEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "childValue")
    private String childValue;

    @ManyToOne
    @JoinColumn(name="parent_id", nullable=false)
    @JsonIgnore
    private ParentEntity parentEntity;
}
