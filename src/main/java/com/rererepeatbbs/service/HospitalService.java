package com.rererepeatbbs.service;

import com.rererepeatbbs.domain.dto.HospitalResponse;
import com.rererepeatbbs.domain.entity.Hospital;
import com.rererepeatbbs.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HospitalService {
    public final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional(readOnly = true)
    public Page<Hospital> pageList(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }

    public Optional<Hospital> showHospitalInfo(Integer id) {
        return hospitalRepository.findById(id);
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        Hospital hospital = optHospital.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital); // DTO
        if (hospital.getBusinessStatusCode() == 13) {
            hospitalResponse.setBusinessStatusName("영업중");
        } else if (hospital.getBusinessStatusCode() == 3) {
            hospitalResponse.setBusinessStatusName("폐업");
        } else {
            hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
        }
        return hospitalResponse;
    }

    public Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable) {
        return hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
    }
}
