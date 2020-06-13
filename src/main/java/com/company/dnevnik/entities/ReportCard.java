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
@Table(name = "ReportCards")

public class ReportCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "HW_id", referencedColumnName = "id")
    HW hw;
    @ManyToOne
    @JoinColumn(name = "mark_id", referencedColumnName = "id")
    Mark mark;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;
}
