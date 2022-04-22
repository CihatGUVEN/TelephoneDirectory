package com.example.telephonedirectory.repository;

import com.example.telephonedirectory.entity.CommunicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunicationInfoRepository extends JpaRepository<CommunicationInfo, Long> {

    List<CommunicationInfo> getCommunicationInfosByPerson_Id(Long person_id);
}
