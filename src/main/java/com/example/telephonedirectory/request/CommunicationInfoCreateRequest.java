package com.example.telephonedirectory.request;

import com.example.telephonedirectory.model.CommunicationInformationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommunicationInfoCreateRequest {

    private CommunicationInformationType communicationInformationType;

    private String informationContent;
}
