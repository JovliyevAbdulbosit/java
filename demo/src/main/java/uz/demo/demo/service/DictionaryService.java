package uz.demo.demo.service;

import org.springframework.stereotype.Service;
import uz.demo.demo.entity.Dictionary;
import uz.demo.demo.repository.DictionaryRepostory;

import java.util.List;

@Service
public class DictionaryService {
    private final DictionaryRepostory dictionaryRepostory;

    public DictionaryService(DictionaryRepostory dictionaryRepostory) {
        this.dictionaryRepostory = dictionaryRepostory;
    }
    public List<Dictionary> getAll(){
       return dictionaryRepostory.findAll();
    }
    public Dictionary creat(Dictionary dictionary){
       return dictionaryRepostory.save(dictionary);
    }
}
