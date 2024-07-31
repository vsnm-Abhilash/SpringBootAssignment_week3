package com.abhilash.sb.cms_assignment_w3.controllers;

import com.abhilash.sb.cms_assignment_w3.dto.ProfessorDTO;
import com.abhilash.sb.cms_assignment_w3.entities.ProfessorEntity;
import com.abhilash.sb.cms_assignment_w3.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("/{professorId}")
    public ProfessorDTO getProfessorById(@PathVariable Long professorId) {
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorDTO createProfessor(@RequestBody ProfessorDTO professorDTO) {
        return professorService.createProfessor(professorDTO);
    }

    @PutMapping("/{professorId}/assignProfessorToSubject/{subjectId}")
    public ProfessorDTO assignProfessorToSubject(
            @PathVariable Long professorId,
            @PathVariable Long subjectId) {
        return professorService.assignProfessorToSubject(professorId, subjectId);
    }

    @PutMapping("/{professorId}/professorsToStudent/{studentId}")
    public ProfessorDTO professorsToStudent(
            @PathVariable Long professorId,
            @PathVariable Long studentId) {
        return professorService.professorsToStudent(professorId, studentId);
    }

    @GetMapping
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();
    }

}
