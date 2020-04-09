package com.robosh.ejournal.data.dto.school;

import com.robosh.ejournal.data.entity.SettlementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveSchoolDto {

    private String name;

    private String url;

    private String settlementName;

    private String region;

    private String address;

    private SettlementType settlementType;

    private Long directorId;
}
