package com.abhilash.sb.cms_assignment_w3.services;

import com.abhilash.sb.cms_assignment_w3.dto.ProfessorDTO;
import com.abhilash.sb.cms_assignment_w3.entities.ProfessorEntity;
import com.abhilash.sb.cms_assignment_w3.entities.StudentEntity;
import com.abhilash.sb.cms_assignment_w3.entities.SubjectEntity;
import com.abhilash.sb.cms_assignment_w3.exceptions.ResourceNotFoundException;
import com.abhilash.sb.cms_assignment_w3.repositories.ProfessorRepo;
import com.abhilash.sb.cms_assignment_w3.repositories.StudentRepo;
import com.abhilash.sb.cms_assignment_w3.repositories.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ModelMapper mapper;
    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final ProfessorRepo professorRepo;

    public ProfessorDTO getProfessorById(Long professorId) {
        ProfessorEntity professor= professorRepo
                .findById(professorId)
                .orElseThrow(()->new ResourceNotFoundException("Professor not found with id "+professorId));
        return mapper.map(professor, ProfessorDTO.class);
    }

    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
         ProfessorEntity professor=mapper.map(professorDTO,ProfessorEntity.class);
         return mapper.map(professorRepo.save(professor),ProfessorDTO.class);

    }

    public ProfessorDTO assignProfessorToSubject(Long professorId, Long subjectId) {
        ProfessorEntity professor= professorRepo
                .findById(professorId)
                .orElseThrow(()->new ResourceNotFoundException("Professor not found with id "+professorId));

        SubjectEntity subjectEntity= subjectRepo
                .findById(subjectId)
                .orElseThrow(()->new ResourceNotFoundException("Subject with Id "+subjectId+" not found"));

        subjectEntity.setProfessor(professor);
        professor.getSubjects().add(subjectEntity);
        return mapper.map(professorRepo.save(professor),ProfessorDTO.class);



    }

    public ProfessorDTO professorsToStudent(Long professorId, Long studentId) {
        ProfessorEntity professor= professorRepo
                .findById(professorId)
                .orElseThrow(()->new ResourceNotFoundException("Professor not found with id "+professorId));

        StudentEntity student= studentRepo
                .findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student with Id "+studentId+" not found"));
        student.getProfessorsList().add(professor);
        professor.getStudentsList().add(student);
        return mapper.map(professorRepo.save(professor),ProfessorDTO.class);

    }

    public List<ProfessorDTO> getAllProfessors() {

        return professorRepo.findAll()
                .stream()
                .map(professor -> mapper.map(professor,ProfessorDTO.class))
                .collect(Collectors.toList());

    }
}
