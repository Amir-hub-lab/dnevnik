package com.company.dnevnik.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "teachers")

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    User user;

    @ManyToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    Discipline discipline;
}
