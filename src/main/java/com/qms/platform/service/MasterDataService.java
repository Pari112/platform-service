package com.qms.platform.service;

import com.qms.platform.entity.Department;
import com.qms.platform.entity.TicketType;
import com.qms.platform.repository.DepartmentRepository;
import com.qms.platform.repository.TicketTypeRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MasterDataService {

    private DepartmentRepository departmentRepository;
    private TicketTypeRepository ticketTypeRepository;

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<TicketType> findTicketTypes(String departmentCode) {
        return ticketTypeRepository.findByDepartmentCode(departmentCode);
    }

    @Transactional
    public TicketType createTicketType(TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }
}
