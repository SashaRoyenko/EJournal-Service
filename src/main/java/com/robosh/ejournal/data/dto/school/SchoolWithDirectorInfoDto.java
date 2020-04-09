package com.robosh.ejournal.data.dto.school;

import com.robosh.ejournal.data.dto.director.DirectorDto;
import com.robosh.ejournal.data.entity.SettlementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolWithDirectorInfoDto extends SchoolInfoDto {

    private DirectorDto director;

    @Builder(builderMethodName = "schoolWithDirectorBuilder")
    public SchoolWithDirectorInfoDto(
            Long id,
            String name,
            String url,
            String settlementName,
            String region,
            String address,
            SettlementType settlementType,
            DirectorDto director
    ) {
        super(id, name, url, settlementName, region, address, settlementType);
        this.director = director;
    }
}
