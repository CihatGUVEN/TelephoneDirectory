package com.example.telephonedirectory.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonCreateRequest {
    private String firstname;
    private String lastname;
    private String company;
}
