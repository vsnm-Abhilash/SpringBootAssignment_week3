package com.abhilash.sb.cms_assignment_w3.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRecDTO {
    private Long admissionId;
    private Double fees;
    private Long studentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdmissionRecDTO that)) return false;
        return Objects.equals(admissionId, that.admissionId) && Objects.equals(fees, that.fees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admissionId, fees);
    }
}
