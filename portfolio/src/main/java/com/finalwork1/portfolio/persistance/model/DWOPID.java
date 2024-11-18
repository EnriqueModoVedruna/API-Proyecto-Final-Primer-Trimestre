package com.finalwork1.portfolio.persistance.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class DWOPID implements Serializable {
    private Integer developerId;
    private Integer projectId;
}
