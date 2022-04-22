package com.example.telephonedirectory.controller;


import com.example.telephonedirectory.dto.CommunicationInfoDto;
import com.example.telephonedirectory.request.CommunicationInfoCreateRequest;
import com.example.telephonedirectory.response.CommunicationInfoResponse;
import com.example.telephonedirectory.service.CommunicationInfoService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communicationInfo")
@RequiredArgsConstructor
public class CommunicationInfoController {


    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    private final CommunicationInfoService communicationInfoService;


    @PostMapping
    public ResponseEntity<CommunicationInfoResponse> createCommunicationInfo
            (@RequestBody CommunicationInfoCreateRequest communicationInfoCreateRequest, @RequestParam Long personId) {

        CommunicationInfoDto requestCommunicationInfoDto = dozerBeanMapper.map(communicationInfoCreateRequest, CommunicationInfoDto.class);
        CommunicationInfoDto communicationInfoDto = communicationInfoService.createCommunicationInfo(requestCommunicationInfoDto, personId);

        return ResponseEntity.ok(dozerBeanMapper.map(communicationInfoDto, CommunicationInfoResponse.class));
    }

    @DeleteMapping("/{id}")
    public void deleteCommunicationInfo(@PathVariable Long id){
        communicationInfoService.deleteCommunicationInfo(id);
    }
}
