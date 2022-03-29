package uz.demo.demo.urls;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.demo.demo.entity.Dictionary;
import uz.demo.demo.service.DictionaryService;

@RestController
@RequestMapping("/dic")
public class DictionaryUrl {
    private final DictionaryService dictionaryService;

    public DictionaryUrl(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/all")
    public ResponseEntity allGet(){
        return ResponseEntity.ok(dictionaryService.getAll());
    }
    @PostMapping("/creat")
    public ResponseEntity add(@RequestBody Dictionary dict){
        return ResponseEntity.ok(dictionaryService.creat(dict));
    }
}
