package com.rererepeatbbs.domain.entity;

import com.rererepeatbbs.domain.dto.HospitalResponse;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "nation_wide_hospitals")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    private Integer id;

    @Column(name = "open_service_name")
    private String openServiceName;

    @Column(name = "open_local_government_code")
    private Integer openLocalGovernmentCode;

    @Column(name = "management_number")
    private String managementNumber;

    @Column(name = "license_date")
    private LocalDateTime licenseDate;

    @Column(name = "business_status")
    private Integer businessStatus;

    @Column(name = "business_status_code")
    private Integer businessStatusCode;

    private String phone;

    @Column(name = "full_address")
    private String fullAddress;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "business_type_name")
    private String businessTypeName;

    @Column(name = "healthcare_provider_count")
    private Integer healthcareProviderCount;

    @Column(name = "patient_room_count")
    private Integer patientRoomCount;

    @Column(name = "total_number_of_beds")
    private Integer totalNumberOfBeds;

    @Column(name = "total_area_size")
    private Float totalAreaSize;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;

    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(),
                hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getBusinessTypeName(),
                hospital.getTotalAreaSize());
    }

}
