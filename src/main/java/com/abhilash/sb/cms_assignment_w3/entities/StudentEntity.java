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
@Table(name="students")
public class StudentEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_professor_mapping",
            joinColumns = @JoinColumn(name="student_ids"),
            inverseJoinColumns = @JoinColumn(name = "professor_ids"))
    private Set<ProfessorEntity> professorsList;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject_mapping",
            joinColumns = @JoinColumn(name="student_ids"),
            inverseJoinColumns = @JoinColumn(name = "subject_ids"))
    private Set<SubjectEntity> subjectsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(studentId, that.studentId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name);
    }
}
