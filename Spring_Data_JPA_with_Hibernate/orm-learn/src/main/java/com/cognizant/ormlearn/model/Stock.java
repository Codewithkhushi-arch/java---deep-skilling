package com.cognizant.ormlearn.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code", length = 10, nullable = false)
    private String code;

    @Column(name = "st_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "st_open", precision = 10, scale = 2, nullable = false)
    private BigDecimal open;

    @Column(name = "st_close", precision = 10, scale = 2, nullable = false)
    private BigDecimal close;

    @Column(name = "st_volume", nullable = false)
    private long volume;
}
