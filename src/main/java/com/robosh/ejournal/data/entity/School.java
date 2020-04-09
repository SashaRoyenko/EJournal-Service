package com.robosh.ejournal.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "school")
public class School {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @NotBlank
    @Column(name = "settlement_name")
    private String settlementName;

    @NotBlank
    @Column(name = "region")
    private String region;

    @NotBlank
    @Column(name = "address")
    private String address;

    @Column(name = "settlement_type")
    private SettlementType settlementType;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
