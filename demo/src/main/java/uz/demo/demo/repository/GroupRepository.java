package uz.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.demo.demo.entity.Group;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
//    @Query(value = "Select group1.id , group1.type , group1_student.student_id  from \n" +
//            "group1 right join group1_student  on group1.id=group1_student.group_id" , nativeQuery = true)
//     public List<Group> finddAll();
    public List<Group> getByIdOrType(Long id , String type);
}
