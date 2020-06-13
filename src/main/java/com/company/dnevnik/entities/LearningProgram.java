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
@Table(name = "learning_program")

public class LearningProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "hours")
    Integer hours;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    Discipline discipline;
}