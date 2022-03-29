package uz.demo.demo.urls;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.demo.demo.entity.Group;
import uz.demo.demo.service.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UrlGroup {
    private final GroupService groupService;

    public UrlGroup(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/group")
    public ResponseEntity creat(@RequestBody Group group){
       Group result = groupService.saqlash(group) ;
       return ResponseEntity.ok(result);
    }
    @GetMapping("/group")
    public ResponseEntity getAllUrl(){
        System.out.println(groupService.getAll());
        return ResponseEntity.ok(groupService.getAll());
    }
    @GetMapping("/group/{id}")
    public ResponseEntity getAllUrl(@PathVariable Long id){
        Optional<Group> result = groupService.getOne(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/type")
    public ResponseEntity type(@RequestParam("id") Long id , @RequestParam("type") String type){
        return ResponseEntity.ok(groupService.getGroup(id,type));
    }



}
