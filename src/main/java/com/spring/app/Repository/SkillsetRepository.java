package com.spring.app.Repository;

import com.spring.app.model.skillset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsetRepository extends JpaRepository<skillset,Long> {


}
