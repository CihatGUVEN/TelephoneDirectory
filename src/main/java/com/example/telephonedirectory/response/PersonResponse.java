package com.example.telephonedirectory.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String company;
}
