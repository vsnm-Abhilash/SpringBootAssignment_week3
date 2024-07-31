package com.abhilash.sb.cms_assignment_w3.services;

import com.abhilash.sb.cms_assignment_w3.dto.StudentDTO;
import com.abhilash.sb.cms_assignment_w3.entities.StudentEntity;
import com.abhilash.sb.cms_assignment_w3.entities.SubjectEntity;
import com.abhilash.sb.cms_assignment_w3.exceptions.ResourceNotFoundException;
import com.abhilash.sb.cms_assignment_w3.repositories.StudentRepo;
import com.abhilash.sb.cms_assignment_w3.repositories.SubjectRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final ModelMapper mapper;

    public StudentDTO getStudentById(Long studentId) {
        StudentEntity student=studentRepo
                .findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student with Id "+studentId+" not found"));

        return mapper.map(student,StudentDTO.class);
    }

    public StudentDTO createNewStudent(StudentDTO studentDTO) {
        StudentEntity student=mapper.map(studentDTO,StudentEntity.class);
        return mapper.map(studentRepo.save(student),StudentDTO.class);
    }

    @Transactional
    public StudentDTO assignStudentToSubject(Long studentId, Long subjectId) {
        StudentEntity studentEntity=studentRepo
                .findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student with Id "+studentId+" not found"));

        SubjectEntity subjectEntity= subjectRepo
                .findById(subjectId)
                .orElseThrow(()->new ResourceNotFoundException("Subject with Id "+subjectId+" not found"));

        studentEntity.getSubjectsList().add(subjectEntity);
        subjectEntity.getStudentsList().add(studentEntity);
        return mapper.map(studentRepo.save(studentEntity),StudentDTO.class);

    }

    public List<StudentDTO> getAllStudents() {
        return studentRepo.findAll()
                .stream()
                .map(student->mapper.map(student,StudentDTO.class))
                .collect(Collectors.toList());
    }
}
