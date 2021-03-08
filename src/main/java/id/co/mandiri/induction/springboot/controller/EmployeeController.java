package id.co.mandiri.induction.springboot.controller;

import id.co.mandiri.induction.springboot.model.entity.Employees;
import id.co.mandiri.induction.springboot.model.response.EmployeeDto;
import id.co.mandiri.induction.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/optional/{id}")
    public Optional<Employees> getEmployeeOptional(@PathVariable Integer id) {
        return employeeService.getEmployeeOptionalById(id);
    }

    @GetMapping(value = "/{id}")
    public Employees getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/list")
    public List<Employees> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping(value = "/custom")
    public List<EmployeeDto> getEmployeeListCustom() {
        return employeeService.getEmployeeList().stream().map(e -> EmployeeDto.builder()
                .employeeId(e.getEmployeeId())
                .firstName(e.getFirstName())
                .build()
        ).collect(Collectors.toList());
    }



}
