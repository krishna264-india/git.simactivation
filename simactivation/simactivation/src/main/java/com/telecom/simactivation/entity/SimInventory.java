package com.telecom.simactivation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sim_inventory")
@Data @Setter @Getter
public class SimInventory {

    @Id
    private String simNumber;

    private String status;

    private String operatorName;
}
