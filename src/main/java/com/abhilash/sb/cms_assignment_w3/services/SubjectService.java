package com.abhilash.sb.cms_assignment_w3.services;

import com.abhilash.sb.cms_assignment_w3.dto.SubjectDTO;
import com.abhilash.sb.cms_assignment_w3.entities.StudentEntity;
import com.abhilash.sb.cms_assignment_w3.entities.SubjectEntity;
import com.abhilash.sb.cms_assignment_w3.exceptions.ResourceNotFoundException;
import com.abhilash.sb.cms_assignment_w3.repositories.StudentRepo;
import com.abhilash.sb.cms_assignment_w3.repositories.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final ModelMapper mapper;

    public SubjectDTO getSubjectById(Long subjectId) {
        SubjectEntity subject=subjectRepo
                .findById(subjectId)
                .orElseThrow(()->new ResourceNotFoundException("Subject with Id "+subjectId+" not found"));
        return mapper.map(subject,SubjectDTO.class);
    }

    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        SubjectEntity subject=mapper.map(subjectDTO,SubjectEntity.class);
        return mapper.map(subjectRepo.save(subject),SubjectDTO.class);
    }

    public SubjectDTO assignSubjectToStudent(Long subjectId, Long studentId) {
        StudentEntity studentEntity=studentRepo
                .findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student with Id "+studentId+" not found"));

        SubjectEntity subjectEntity= subjectRepo
                .findById(subjectId)
                .orElseThrow(()->new ResourceNotFoundException("Subject with Id "+subjectId+" not found"));

        subjectEntity.getStudentsList().add(studentEntity);
        studentEntity.getSubjectsList().add(subjectEntity);
        return mapper.map(subjectRepo.save(subjectEntity),SubjectDTO.class);

    }

    public List<SubjectDTO> getAllSubjects() {
        return subjectRepo.findAll()
                .stream()
                .map(subject->mapper.map(subject,SubjectDTO.class))
                .collect(Collectors.toList());
    }
}
