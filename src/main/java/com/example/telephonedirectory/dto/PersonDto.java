package com.example.telephonedirectory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String company;
    private List<CommunicationInfoDto> communicationInfoList;
}
