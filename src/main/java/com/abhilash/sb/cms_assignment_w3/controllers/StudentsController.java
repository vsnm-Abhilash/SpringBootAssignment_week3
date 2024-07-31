package com.abhilash.sb.cms_assignment_w3.controllers;

import com.abhilash.sb.cms_assignment_w3.dto.ProfessorDTO;
import com.abhilash.sb.cms_assignment_w3.dto.StudentDTO;
import com.abhilash.sb.cms_assignment_w3.entities.StudentEntity;
import com.abhilash.sb.cms_assignment_w3.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public StudentDTO getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentDTO createNewStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createNewStudent(studentDTO);
    }

    @PutMapping(path = "/{studentId}/subject/{subjectId}")
    public StudentDTO assignStudentToSubject(@PathVariable Long studentId,
                                                @PathVariable Long subjectId){
        return studentService.assignStudentToSubject(studentId, subjectId);
    }
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
}
