package id.co.mandiri.induction.springboot.service.impl;

import id.co.mandiri.induction.springboot.model.entity.Employees;
import id.co.mandiri.induction.springboot.repository.EmployeesRepository;
import id.co.mandiri.induction.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Optional<Employees> getEmployeeOptionalById(Integer id) {
        return null;
    }

    @Override
    public Employees getEmployeeById(Integer id) {
        return employeesRepository.cariDenganEmployeeId(id);
    }

    @Override
    public List<Employees> getEmployeeList() {
        return employeesRepository.findAll();
    }
}
