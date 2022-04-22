package com.example.telephonedirectory.response;

import com.example.telephonedirectory.model.CommunicationInformationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommunicationInfoResponse {

    private Long id;

    private CommunicationInformationType communicationInformationType;

    private String informationContent;
}
