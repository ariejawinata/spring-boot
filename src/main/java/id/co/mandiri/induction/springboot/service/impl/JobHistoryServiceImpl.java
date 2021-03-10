package id.co.mandiri.induction.springboot.service.impl;

import id.co.mandiri.induction.springboot.model.entity.JobHistory;
import id.co.mandiri.induction.springboot.repository.JobHistoryRepository;
import id.co.mandiri.induction.springboot.service.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobHistoryServiceImpl implements JobHistoryService {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;


    @Override
    public List<JobHistory> findAllJobHistoryLeftJoinDepartmentsByJobId(String jobId) {
        return jobHistoryRepository.leftJoin(jobId);
    }

    @Override
    public List<JobHistory> findAllJobHistoryRightJoinDepartmentsByJobId(String jobId) {
        return jobHistoryRepository.findAllJobHistoryRightJoinDepartmentsByJobId(jobId);
    }

    @Override
    public List<String> findAllDepartmentNameOuterJoinByLocationId(Integer locationId) {
        return jobHistoryRepository.findAllDepartmentNameOuterJoinByLocationId(locationId);
    }

    @Override
    public void upsertAllJobHistoryByEmployee() {
        jobHistoryRepository.upsertAllJobHistoryByEmployee();
    }
}
