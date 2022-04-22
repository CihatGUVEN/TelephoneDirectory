package com.example.telephonedirectory;

import com.example.telephonedirectory.dto.CommunicationInfoDto;
import com.example.telephonedirectory.dto.PersonDto;
import com.example.telephonedirectory.entity.CommunicationInfo;
import com.example.telephonedirectory.entity.Person;
import com.example.telephonedirectory.model.CommunicationInformationType;
import com.example.telephonedirectory.repository.CommunicationInfoRepository;
import com.example.telephonedirectory.service.CommunicationInfoService;
import com.example.telephonedirectory.service.PersonService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommunicationInfoServiceTest {

    @Mock
    private CommunicationInfoRepository communicationInfoRepository;

    @Mock
    private PersonService personService;

    @InjectMocks
    @Spy
    private CommunicationInfoService communicationInfoService;

    Person person;
    PersonDto personDto;
    CommunicationInfo communicationInfo;
    CommunicationInfoDto communicationInfoDto;


    @Before
    public void init() {

        person = Person.builder()
                .id(1L)
                .firstname("cihat")
                .lastname("güven")
                .company("cava.ltd")
                .build();

        personDto = PersonDto.builder()
                .id(person.getId())
                .firstname(person.getFirstname())
                .lastname(person.getLastname())
                .company(person.getCompany())
                .build();

        communicationInfo = CommunicationInfo.builder()
                .id(1L)
                .communicationInformationType(CommunicationInformationType.PHONE_NUMBER)
                .informationContent("1237162547162563")
                .person(person)
                .build();

         communicationInfoDto = CommunicationInfoDto.builder()
                .id(communicationInfo.getId())
                .communicationInformationType(communicationInfo.getCommunicationInformationType())
                .informationContent(communicationInfo.getInformationContent())
                .person(personDto)
                .build();

    }


        @Test
        public void createCommunicationInfo() {
        when(communicationInfoRepository.save(any())).thenReturn(communicationInfo);
        when(personService.getPersonById(1L)).thenReturn(personDto);


        CommunicationInfoDto requestCommunicationInfoDto = communicationInfoService.createCommunicationInfo(communicationInfoDto,1L);

            assertEquals("1237162547162563", requestCommunicationInfoDto.getInformationContent());

        }

        @Test
        public void deleteCommunicationInfo(){

            communicationInfoService.deleteCommunicationInfo(1L);
            verify(communicationInfoRepository).deleteById(1L);

        }

































}
