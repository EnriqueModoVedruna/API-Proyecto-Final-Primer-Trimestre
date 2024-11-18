package com.finalwork1.portfolio.persistance.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class TUIPID {
    private Integer techId;
    private Integer projectId;
    
}
