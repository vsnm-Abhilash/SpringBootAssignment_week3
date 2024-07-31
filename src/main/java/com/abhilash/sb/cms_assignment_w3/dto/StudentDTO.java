package com.abhilash.sb.cms_assignment_w3.dto;

import com.abhilash.sb.cms_assignment_w3.entities.ProfessorEntity;
import com.abhilash.sb.cms_assignment_w3.entities.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long studentId;
    private String name;
    private Set<ProfessorDTO> professorsList;
    private Set<SubjectDTO> subjectsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO that)) return false;
        return Objects.equals(studentId, that.studentId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name);
    }
}
