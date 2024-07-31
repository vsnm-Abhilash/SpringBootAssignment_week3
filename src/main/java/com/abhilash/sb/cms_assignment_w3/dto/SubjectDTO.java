package com.abhilash.sb.cms_assignment_w3.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Long subjectId;
    private String title;
    private Long professorId;
    @JsonIgnore
    private Set<StudentDTO> studentsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDTO that)) return false;
        return Objects.equals(subjectId, that.subjectId) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, title);
    }
}
