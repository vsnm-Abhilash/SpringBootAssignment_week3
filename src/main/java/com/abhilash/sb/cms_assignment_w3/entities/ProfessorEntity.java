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
@Table(name="professors")
public class ProfessorEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private Set<SubjectEntity> subjects;

    @ManyToMany(mappedBy = "professorsList")
    @JsonIgnore
    private Set<StudentEntity> studentsList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorEntity that)) return false;
        return Objects.equals(professorId, that.professorId) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, title);
    }
}
