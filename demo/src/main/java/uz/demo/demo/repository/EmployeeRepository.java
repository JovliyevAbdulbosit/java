package uz.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.demo.demo.entity.Student;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Student,Long> {
    @Query(value = "Select * from bu_student where bu_student.name like %:name% " , nativeQuery = true)
        public List<Student>  findAll(@Param("name")  String name);
}