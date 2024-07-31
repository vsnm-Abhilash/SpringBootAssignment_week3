package com.abhilash.sb.cms_assignment_w3.controllers;

import com.abhilash.sb.cms_assignment_w3.dto.AdmissionRecDTO;
import com.abhilash.sb.cms_assignment_w3.dto.ProfessorDTO;
import com.abhilash.sb.cms_assignment_w3.services.AdmissionRecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admissions")
@RequiredArgsConstructor
public class AdmissionRecController {

    private final AdmissionRecService admissionRecService;


    @GetMapping(path = "/{admissionRecId}")
    public AdmissionRecDTO getAdmissionRecordById(@PathVariable Long admissionRecId){
        return admissionRecService.getAdmissionRecords(admissionRecId);
    }

    @PostMapping
    public AdmissionRecDTO createNewAdmissionRecord(@RequestBody AdmissionRecDTO admissionRecDTO){
        return admissionRecService.createAdmissionRecord(admissionRecDTO);
    }

    @PutMapping("/{admissionRecordId}/admission/{studentId}")
    public AdmissionRecDTO admissionRecordOfStudent(
            @PathVariable Long admissionRecordId,
            @PathVariable Long studentId){

        return admissionRecService.admissionRecordOfStudent(admissionRecordId,studentId);

    }

    @GetMapping
    public List<AdmissionRecDTO> getAllAdmissions() {
        return admissionRecService.getAllAdmissions();
    }
}
