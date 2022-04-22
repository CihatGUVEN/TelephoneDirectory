package com.example.telephonedirectory;


import com.example.telephonedirectory.dto.PersonDto;
import com.example.telephonedirectory.entity.Person;
import com.example.telephonedirectory.repository.PersonRepository;
import com.example.telephonedirectory.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    @Spy
    private PersonService personService;

    private Person person;
    private PersonDto personDto;

    @Before
    public void init(){
        person = Person.builder()
                .id(1L)
                .firstname("ali")
                .lastname("veli")
                .company("ltd")
                .build();

        personDto = PersonDto.builder()
                .firstname(person.getFirstname())
                .lastname(person.getLastname())
                .company(person.getCompany())
                .build();

    }

    @Test
    public void createPerson(){
        when(personRepository.save(any())).thenReturn(person);

        PersonDto returnPersonDto = personService.createPerson(personDto);

        assertEquals(Optional.of(1L), Optional.ofNullable(returnPersonDto.getId()));
        assertEquals("ali", returnPersonDto.getFirstname());
    }

    @Test
    public void deletePerson() {
        personService.deletePerson(1L);
        verify(personRepository).deleteById(1L);
    }

    @Test
    public void getAllPersons(){
        when(personRepository.findAll()).thenReturn(List.of(person));

        List<PersonDto> returnPersonDtoList = personService.getAllPersons();

        assertEquals(1,returnPersonDtoList.size());
        assertEquals("ali", returnPersonDtoList.get(0).getFirstname());

    }

    @Test
    public void getPersonById(){

        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person));

        PersonDto returnPersonDto = personService.getPersonById(1L);

        assertEquals(Optional.of(1L),Optional.of(returnPersonDto.getId()));

    }
















}
