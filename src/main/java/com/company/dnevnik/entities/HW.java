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
@Table(name = "HWs")

public class HW {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "comment_text")
    String commentText;

    @CreatedDate
    @Column(name = "date")
    Date date = new Date();

    @OneToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    Topic topic;
}
