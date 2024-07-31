package com.abhilash.sb.cms_assignment_w3.controllers;

import com.abhilash.sb.cms_assignment_w3.dto.ProfessorDTO;
import com.abhilash.sb.cms_assignment_w3.dto.SubjectDTO;
import com.abhilash.sb.cms_assignment_w3.entities.SubjectEntity;
import com.abhilash.sb.cms_assignment_w3.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/{subjectId}")
    public SubjectDTO getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.createSubject(subjectDTO);
    }

    @PutMapping("/{subjectId}/student/{studentId}")
    public SubjectDTO assignSubjectToStudent(
            @PathVariable Long subjectId,
            @PathVariable Long studentId){
        return subjectService.assignSubjectToStudent(subjectId,studentId);
    }

    @GetMapping
    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
