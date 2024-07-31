package com.abhilash.sb.cms_assignment_w3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subjects")
public class SubjectEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="subject_professor_id")
    private ProfessorEntity professor;

    @ManyToMany(mappedBy = "subjectsList")
    @JsonIgnore
    private Set<StudentEntity> studentsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectEntity that)) return false;
        return Objects.equals(subjectId, that.subjectId) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, title);
    }
}
