package com.dubo.controller;

import com.dubo.entity.Girl;
import com.dubo.repository.GrilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GrilRepository grilRepository;

    public void setGrilRepository(GrilRepository grilRepository) {
        this.grilRepository = grilRepository;
    }

    @GetMapping("/gril")
    public List<Girl> getList(){
        return grilRepository.findAll();
    }

    @PostMapping("/insert")
    public Girl insertGirl(@RequestParam("cupSize")String a,@RequestParam("name")String b,@RequestParam("age")int c){
        Girl girl=new Girl();
        girl.setAge(c);
        girl.setCupSize(b);
        girl.setName(a);
        return grilRepository.save(girl);
    }
    @GetMapping("/get/{id}")
    public Girl getGirl(@PathVariable("id")Integer id){
        System.out.println("what's happen?");
        return grilRepository.findOne(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteGirl(@PathVariable("id")Integer id){
         grilRepository.delete(id);
    }
    @PostMapping("/update/{id}")
    public Girl update(@PathVariable("id")Integer id,String cupSize,String name,int age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setName(name);
        girl.setAge(age);
        return grilRepository.save(girl);
    }
}
