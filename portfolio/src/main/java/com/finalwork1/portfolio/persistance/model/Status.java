package com.finalwork1.portfolio.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="status")
@Data
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="status_id", nullable= false)
    Integer id;

    @Column(name="status_name", nullable = false)
    String nombreStatus;

}
