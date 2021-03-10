package id.co.mandiri.induction.springboot.service;

import id.co.mandiri.induction.springboot.model.entity.JobHistory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobHistoryService {

    List<JobHistory> findAllJobHistoryLeftJoinDepartmentsByJobId(String jobId);

    List<JobHistory> findAllJobHistoryRightJoinDepartmentsByJobId(String jobId);

    List<String> findAllDepartmentNameOuterJoinByLocationId(Integer locationId);

    void upsertAllJobHistoryByEmployee();

}
