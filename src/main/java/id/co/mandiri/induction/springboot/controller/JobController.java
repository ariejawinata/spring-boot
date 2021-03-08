package id.co.mandiri.induction.springboot.controller;

import id.co.mandiri.induction.springboot.model.entity.Jobs;
import id.co.mandiri.induction.springboot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "")
    public List<Jobs> findAllByJobIdAndJobTitle(@RequestParam String jobId, @RequestParam String jobTitle) {
        return jobService.findAllByJobIdOrJobTitle(jobId, jobTitle);
    }

    @GetMapping(value = "/min-salary")
    public List<Jobs> findAllJobByMinSalaryBetween(@RequestParam Integer minSalaryA, @RequestParam Integer minSalaryB) {
        return jobService.findAllJobByMinSalaryBetween(minSalaryA, minSalaryB);
    }

    @GetMapping(value = "/salary-year")
    public List<Jobs> findAllJobByYearAndSalary(@RequestParam String year, @RequestParam Integer salary) {
        return jobService.findAllJobByYearAndSalary(year, salary);
    }

}
