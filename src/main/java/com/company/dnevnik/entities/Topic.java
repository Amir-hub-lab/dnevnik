package com.company.dnevnik.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "topics")

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name", unique = true)
    String name;

    @Column(name = "hours")
    Integer hours;

    @ManyToOne
    @JoinColumn(name = "learning_program_id", referencedColumnName = "id")
    LearningProgram learningProgram;
}
