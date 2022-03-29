package uz.demo.demo.urls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.demo.demo.entity.Account;
import uz.demo.demo.repository.AccountRepository;

import java.util.List;

@Controller
public class Home {
    @Autowired
    private  AccountRepository accountRepository;
    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/ingliz")
    public String index(){
        return "english";
    }
    @GetMapping("/add")
    public String add(){
        return "add";
    }
    @GetMapping("/model")
    public ModelAndView gets(){
        ModelAndView mov = new ModelAndView("database");
        List<Account> data = accountRepository.findAll();

        mov.addObject("datas",data);
        return mov;
    }
    @GetMapping("/model/{id}/dd")
    public String test(@PathVariable Integer id){
        return "tests";
    }
}
