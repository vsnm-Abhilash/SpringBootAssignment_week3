package com.abhilash.sb.cms_assignment_w3.repositories;

import com.abhilash.sb.cms_assignment_w3.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity,Long> {
}
