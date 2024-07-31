package com.abhilash.sb.cms_assignment_w3.dto;


import com.abhilash.sb.cms_assignment_w3.entities.StudentEntity;
import com.abhilash.sb.cms_assignment_w3.entities.SubjectEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private Long professorId;
    private String title;
    @JsonIgnore
    private Set<SubjectDTO> subjects;
    @JsonIgnore
    private Set<StudentDTO> studentsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorDTO that)) return false;
        return Objects.equals(professorId, that.professorId) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, title);
    }

}
