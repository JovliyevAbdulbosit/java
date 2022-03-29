package uz.demo.demo.service;

import org.springframework.stereotype.Service;
import uz.demo.demo.entity.Student;
import uz.demo.demo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Student saqlash(Student student){
       return employeeRepository.save(student) ;
    }
    public void uchirish(Long id){
        employeeRepository.deleteById(id);
    }
    public Optional<Student> findId(Long id){
        return employeeRepository.findById(id);
    }
    public List<Student> hammasi(String name){
        List<Student> result = employeeRepository.findAll(name);
        return result ;
    }
}
