package id.co.mandiri.induction.springboot.repository;

import id.co.mandiri.induction.springboot.model.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, String> {

    //left join
    @Query(value = "SELECT jh.* FROM JOB_HISTORY jh LEFT OUTER JOIN DEPARTMENTS d2 ON jh.DEPARTMENT_ID = d2.DEPARTMENT_ID WHERE jh.JOB_ID = :jobId", nativeQuery = true)
    List<JobHistory> leftJoin(String jobId);

    //right join
    @Query(nativeQuery = true, value = "SELECT jh.* FROM JOB_HISTORY jh RIGHT JOIN DEPARTMENTS d2 ON jh.DEPARTMENT_ID = d2.DEPARTMENT_ID WHERE jh.JOB_ID = :jobId")
    List<JobHistory> findAllJobHistoryRightJoinDepartmentsByJobId(String jobId);

    //outer join
    @Query(nativeQuery = true, value = "SELECT d2.DEPARTMENT_NAME FROM JOB_HISTORY jh FULL outer JOIN DEPARTMENTS d2 ON jh.DEPARTMENT_ID = d2.DEPARTMENT_ID WHERE d2.LOCATION_ID = :locationId")
    List<String> findAllDepartmentNameOuterJoinByLocationId(Integer locationId);

    //upsert
    @Modifying
    @Query(nativeQuery = true, value = "MERGE INTO JOB_HISTORY jh\n" +
            "USING (SELECT * FROM EMPLOYEES e2) e ON (jh.EMPLOYEE_ID = e.EMPLOYEE_ID)\n" +
            "WHEN MATCHED THEN \n" +
            "\tUPDATE SET jh.MODIFIED_DATE = CURRENT_TIMESTAMP \n" +
            "WHEN NOT MATCHED THEN \n" +
            "\tINSERT (jh.EMPLOYEE_ID, jh.START_DATE, jh.END_DATE, jh.JOB_ID, jh.DEPARTMENT_ID, jh.MODIFIED_DATE) \n" +
            "\tVALUES (e.EMPLOYEE_ID, TO_DATE('01-01-2010'), SYSDATE, e.JOB_ID, e.DEPARTMENT_ID, CURRENT_TIMESTAMP)")
    void upsertAllJobHistoryByEmployee();

}