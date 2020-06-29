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
@Table(name = "hws")

public class HW {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "comment_text")
    String commentText;

    @Column(name = "mark")
    Integer mark;

    @Builder.Default
    @CreatedDate
    @Column(name = "date")
    Date date = new Date();

    @OneToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "report_card_id", referencedColumnName = "id")
    ReportCard reportCard;
}