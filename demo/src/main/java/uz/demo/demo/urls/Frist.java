package uz.demo.demo.urls;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.demo.demo.entity.Student;
import uz.demo.demo.service.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Frist {
     private final EmployeeService employeeService;

    public Frist(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//    @GetMapping("/get")
//    public ResponseEntity son(){
//        Map<String , Integer> list = new HashMap<>();
//        list.put("id" , 2);
//        list.put("name" , 2);
//        list.put("full" , 2);
//
//
//        return ResponseEntity.ok(list);
//    }
//    @PostMapping("/post")
//    public ResponseEntity creat(@RequestBody Model model){
//        System.out.println(model.info());
//
//        return ResponseEntity.ok(model);
//    }
//    @PutMapping("/student")
//    public ResponseEntity puts(@RequestBody Model model){
//        System.out.println(model.info());
//        model.setAge("20");
//        return ResponseEntity.ok(model);
//    }
//    @PutMapping("/student/{id}")
//    public ResponseEntity<Model> put(@PathVariable("id") int id,@RequestBody Model model){
//        model.setAge("keldi");
//        model.setId(1997);
//        return ResponseEntity.ok(model);
//    }
//    @GetMapping("/student/{id}")
//    public ResponseEntity<Integer> getOne(@PathVariable int id){
//
//        return ResponseEntity.ok(id);
//    }
//    @GetMapping("/param")
//    public ResponseEntity<Integer> getParam(@RequestParam int i){
//
//        return ResponseEntity.ok(i);
//    }
//    @DeleteMapping("/delet/{son}")
//    public ResponseEntity del(@PathVariable int son){
//        return ResponseEntity.ok(son +" del");
//    }


    @PostMapping("/new/employe")
    public ResponseEntity postStudent(@RequestBody Student student){
        Student result = employeeService.saqlash(student);
        return ResponseEntity.ok(result) ;
    }
    @PutMapping("/new/employe")
    public ResponseEntity putStudent(@RequestBody Student student){
        if (student.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        Student result = employeeService.saqlash(student);
        return ResponseEntity.ok(result) ;
    }

    @DeleteMapping("/new/employe/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id ){
        if (id == null){
            return ResponseEntity.badRequest().build();
        }
         employeeService.uchirish(id);
        return ResponseEntity.ok("o'chirldi") ;
    }
    @GetMapping("/new/employe/{id}")
    public ResponseEntity getOneStudent(@PathVariable Long id ){
        Optional<Student> result = employeeService.findId(id);
        if (result.isPresent()){
            return ResponseEntity.ok(result.get());
        }


        return ResponseEntity.ok("page not fund") ;
    }
    @GetMapping("/new/employe")
    public ResponseEntity getAllStudent(@RequestParam String name){
        return ResponseEntity.ok(employeeService.hammasi(name));
    }


}
