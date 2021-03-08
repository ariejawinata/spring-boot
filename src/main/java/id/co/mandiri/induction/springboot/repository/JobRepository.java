package id.co.mandiri.induction.springboot.repository;

import id.co.mandiri.induction.springboot.model.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Jobs, String> {

    List<Jobs> findAllByJobIdOrJobTitle(String jobId, String JobTitle);

    @Query(nativeQuery = true, value = "select * from Jobs j where j.min_salary >= :minSalaryA and j.min_salary <= :minSalaryB")
    List<Jobs> findAllJobByMinSalaryBetween(Integer minSalaryA, Integer minSalaryB);

    @Query(nativeQuery = true, value = "select j.* from Jobs j inner join Employees e on e.job_id = j.job_id where TO_CHAR(e.hire_date, 'YYYY') = :year and e.salary > :salary")
    List<Jobs> findAllJobByYearAndSalary(String year, Integer salary);

}