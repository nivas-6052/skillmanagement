package com.spring.app.Repository;

import com.spring.app.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRRepository  extends JpaRepository<HR, Long> {

}
