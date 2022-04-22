package com.example.telephonedirectory.service;

import com.example.telephonedirectory.dto.CommunicationInfoDto;
import com.example.telephonedirectory.dto.PersonDto;
import com.example.telephonedirectory.entity.Person;
import com.example.telephonedirectory.exception.PersonNotFoundException;
import com.example.telephonedirectory.repository.PersonRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final CommunicationInfoService communicationInfoService;

    public PersonService(PersonRepository personRepository, CommunicationInfoService communicationInfoService) {
        this.personRepository = personRepository;
        this.communicationInfoService = communicationInfoService;
    }

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public PersonDto createPerson(PersonDto personDto) {

        Person person = personRepository.save(dozerBeanMapper.map(personDto, Person.class));

        return dozerBeanMapper.map(person, PersonDto.class);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public PersonDto getPersonById(Long personId) {

        Person person = personRepository.findById(personId).
                orElseThrow(() -> new PersonNotFoundException(personId));

        PersonDto personDto = dozerBeanMapper.map(person, PersonDto.class);

        List<CommunicationInfoDto> communicationInfoDtoList = communicationInfoService.getAllCommunicationInfoByPersonId(personId);

        personDto.setCommunicationInfoList(communicationInfoDtoList);

        return personDto;
    }


    public List<PersonDto> getAllPersons() {

        List<Person> personList = personRepository.findAll();

        return personList.stream().map(person ->
                dozerBeanMapper.map(person, PersonDto.class)).collect(Collectors.toList());
    }
}
