package uz.demo.demo.service;

import org.springframework.stereotype.Service;
import uz.demo.demo.entity.Group;
import uz.demo.demo.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService  {
    private final GroupRepository groupRepository ;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group saqlash(Group group){
        return groupRepository.save(group) ;
    }
    public List<Group> getAll(){
        List<Group> all = groupRepository.findAll();
        return all;
    }
    public Optional<Group> getOne(Long id){
        return groupRepository.findById(id) ;
    }
    public List<Group> getGroup(Long id , String type){
        return (List<Group>) groupRepository.getByIdOrType(id,type);
    }
}
