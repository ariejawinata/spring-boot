package id.co.mandiri.induction.springboot.service;

import id.co.mandiri.induction.springboot.model.entity.Jobs;

import java.util.List;

public interface JobService {

    List<Jobs> findAllByJobIdOrJobTitle(String jobId, String jobTitle);

    List<Jobs> findAllJobByMinSalaryBetween(Integer minSalary, Integer maxSalary);

    List<Jobs> findAllJobByYearAndSalary(String year, Integer salary);

}
