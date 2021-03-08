package id.co.mandiri.induction.springboot.service.impl;

import id.co.mandiri.induction.springboot.model.entity.Jobs;
import id.co.mandiri.induction.springboot.repository.JobRepository;
import id.co.mandiri.induction.springboot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Jobs> findAllByJobIdOrJobTitle(String jobId, String jobTitle) {
        return jobRepository.findAllByJobIdOrJobTitle(jobId, jobTitle);
    }

    @Override
    public List<Jobs> findAllJobByMinSalaryBetween(Integer minSalaryA, Integer minSalaryB) {
        return jobRepository.findAllJobByMinSalaryBetween(minSalaryA, minSalaryB);
    }

    @Override
    public List<Jobs> findAllJobByYearAndSalary(String year, Integer salary) {
        return jobRepository.findAllJobByYearAndSalary(year, salary);
    }

}
