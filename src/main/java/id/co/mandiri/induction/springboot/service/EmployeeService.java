package id.co.mandiri.induction.springboot.service;

import id.co.mandiri.induction.springboot.model.entity.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employees> getEmployeeOptionalById(Integer id);

    Employees getEmployeeById(Integer id);

    List<Employees> getEmployeeList();



}
