package com.example.telephonedirectory.dto;

import com.example.telephonedirectory.model.CommunicationInformationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunicationInfoDto {

    private Long id;

    private CommunicationInformationType communicationInformationType;

    private String informationContent;

    private PersonDto person;
}
