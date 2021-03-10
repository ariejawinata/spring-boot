package id.co.mandiri.induction.springboot.controller;

import id.co.mandiri.induction.springboot.model.entity.JobHistory;
import id.co.mandiri.induction.springboot.service.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job_history")
public class JobHistoryController {

    @Autowired
    private JobHistoryService jobHistoryService;

    @GetMapping(value = "/left-join")
    public List<JobHistory> findAllJobHistoryLeftJoinDepartmentsByJobId(@RequestParam String jobId) {
        return jobHistoryService.findAllJobHistoryLeftJoinDepartmentsByJobId(jobId);
    }

    @GetMapping(value = "/right-join")
    public List<JobHistory> findAllJobHistoryRightJoinDepartmentsByJobId(@RequestParam String jobId) {
        return jobHistoryService.findAllJobHistoryRightJoinDepartmentsByJobId(jobId);
    }

    @GetMapping(value = "/outer-join")
    public List<String> findAllDepartmentNameOuterJoinByLocationId(@RequestParam Integer locationId) {
        return jobHistoryService.findAllDepartmentNameOuterJoinByLocationId(locationId);
    }


    @PostMapping(value = "/upsert")
    public void upsertAllJobHistoryByEmployee() {
        jobHistoryService.upsertAllJobHistoryByEmployee();
    }
}
