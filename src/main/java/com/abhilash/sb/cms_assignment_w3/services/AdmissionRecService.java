package com.abhilash.sb.cms_assignment_w3.services;

import com.abhilash.sb.cms_assignment_w3.dto.AdmissionRecDTO;
import com.abhilash.sb.cms_assignment_w3.entities.AdmissionRecEntity;
import com.abhilash.sb.cms_assignment_w3.entities.StudentEntity;
import com.abhilash.sb.cms_assignment_w3.exceptions.ResourceNotFoundException;
import com.abhilash.sb.cms_assignment_w3.repositories.AdmissionRecRepo;
import com.abhilash.sb.cms_assignment_w3.repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdmissionRecService {

    private final AdmissionRecRepo admissionRecRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper mapper;

    public AdmissionRecDTO createAdmissionRecord(AdmissionRecDTO admissionRecDTO) {
        AdmissionRecEntity recEntity=mapper.map(admissionRecDTO,AdmissionRecEntity.class);
        return mapper.map(admissionRecRepo.save(recEntity),AdmissionRecDTO.class);
    }

    public AdmissionRecDTO getAdmissionRecords(Long admissionRecId) {
        AdmissionRecEntity admissionRecEntity=admissionRecRepo
                .findById(admissionRecId)
                .orElseThrow(()->new ResourceNotFoundException("Student not found with the provided Admission record id: "+admissionRecId));

        return mapper.map(admissionRecEntity,AdmissionRecDTO.class);
    }

    public AdmissionRecDTO admissionRecordOfStudent(Long admissionRecordId, Long studentId) {
        AdmissionRecEntity admissionRecEntity=admissionRecRepo
                .findById(admissionRecordId)
                .orElseThrow(()->new ResourceNotFoundException("Student not found with the provided Admission record id: "+admissionRecordId));

        StudentEntity studentEntity=studentRepo
                .findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student with Id "+studentId+" not found"));

        admissionRecEntity.setStudent(studentEntity);
        return mapper.map(admissionRecRepo.save(admissionRecEntity),AdmissionRecDTO.class);




    }

    public List<AdmissionRecDTO> getAllAdmissions() {
        return admissionRecRepo.findAll()
                .stream()
                .map(admission-> mapper.map(admission,AdmissionRecDTO.class))
                .collect(Collectors.toList());

    }
}
