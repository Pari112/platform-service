package com.qms.platform.controller;

import com.qms.platform.entity.Department;
import com.qms.platform.entity.TicketType;
import com.qms.platform.service.MasterDataService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/master")
@AllArgsConstructor
public class MasterDataController {

    private MasterDataService masterDataService;

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getDepartments() {
        return ResponseEntity.ok(masterDataService.findAllDepartments());
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        return ResponseEntity.ok(masterDataService.createDepartment(department));
    }

    @GetMapping("/ticket-types")
    public ResponseEntity<List<TicketType>> getTicketTypes(@RequestParam String departmentCode) {
        return ResponseEntity.ok(masterDataService.findTicketTypes(departmentCode));
    }

    @PostMapping("/ticket-types")
    public ResponseEntity<TicketType> createTicketType(@Valid @RequestBody TicketType ticketType) {
        return ResponseEntity.ok(masterDataService.createTicketType(ticketType));
    }
}
