package com.qms.platform.repository;

import com.qms.platform.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, String> {
    List<TicketType> findByDepartmentCode(String departmentCode);
}
