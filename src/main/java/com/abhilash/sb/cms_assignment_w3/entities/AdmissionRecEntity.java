package com.abhilash.sb.cms_assignment_w3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="admissions")
public class AdmissionRecEntity extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;
    private Double fees;
    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

}
