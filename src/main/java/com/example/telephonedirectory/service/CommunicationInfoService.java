package com.example.telephonedirectory.service;

import com.example.telephonedirectory.dto.CommunicationInfoDto;
import com.example.telephonedirectory.dto.PersonDto;
import com.example.telephonedirectory.entity.CommunicationInfo;
import com.example.telephonedirectory.repository.CommunicationInfoRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunicationInfoService {

    private final CommunicationInfoRepository communicationInfoRepository;

    private final PersonService personService;

    public CommunicationInfoService(CommunicationInfoRepository communicationInfoRepository, @Lazy PersonService personService) {
        this.communicationInfoRepository = communicationInfoRepository;
        this.personService = personService;
    }

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public CommunicationInfoDto createCommunicationInfo(CommunicationInfoDto communicationInfoDto, Long personId) {

        PersonDto personDto = personService.getPersonById(personId);
        communicationInfoDto.setPerson(personDto);
        CommunicationInfo communicationInfo = communicationInfoRepository.save(dozerBeanMapper.map(communicationInfoDto, CommunicationInfo.class));

        return dozerBeanMapper.map(communicationInfo, CommunicationInfoDto.class);
    }

    public void deleteCommunicationInfo(Long id) {
        communicationInfoRepository.deleteById(id);
    }

    public List<CommunicationInfoDto> getAllCommunicationInfoByPersonId(Long personId) {

        List<CommunicationInfo> communicationInfoList = communicationInfoRepository.getCommunicationInfosByPerson_Id(personId);

        return communicationInfoList.stream().map(communicationInfo ->
                dozerBeanMapper.map(communicationInfo,CommunicationInfoDto.class)).collect(Collectors.toList());
    }
}

