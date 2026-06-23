package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "question")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "op_qn_id", nullable = false)
    private Question question;

    @Column(name = "op_text", length = 255, nullable = false)
    private String text;

    @Column(name = "op_score", precision = 3, scale = 1, nullable = false)
    private double score;

    @Column(name = "op_is_correct", nullable = false)
    private boolean isCorrect;
}
