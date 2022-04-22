package com.example.telephonedirectory.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonByIdResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String company;
    private List<CommunicationInfoResponse> communicationInfoList;

}
