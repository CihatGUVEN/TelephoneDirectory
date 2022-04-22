package com.example.telephonedirectory.controller;


import com.example.telephonedirectory.dto.PersonDto;
import com.example.telephonedirectory.request.PersonCreateRequest;
import com.example.telephonedirectory.response.PersonByIdResponse;
import com.example.telephonedirectory.response.PersonResponse;
import com.example.telephonedirectory.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonCreateRequest personCreateRequest) {

        PersonDto personDto = personService.createPerson(dozerBeanMapper.map(personCreateRequest, PersonDto.class));

        return ResponseEntity.ok(dozerBeanMapper.map(personDto, PersonResponse.class));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> getAllPersons() {
        List<PersonDto> personDtoList = personService.getAllPersons();
        List<PersonResponse> personResponseList = personDtoList.stream()
                .map(personDto -> dozerBeanMapper.map(personDto, PersonResponse.class)).collect(Collectors.toList());

        return ResponseEntity.ok(personResponseList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PersonByIdResponse> getPersonById(@PathVariable Long id) {
        PersonDto personDto = personService.getPersonById(id);
        return ResponseEntity.ok(dozerBeanMapper.map(personDto, PersonByIdResponse.class));

    }

}



