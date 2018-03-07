package com.dubo.controller;


import com.dubo.entity.Girl;
import com.dubo.entity.Result;
import com.dubo.repository.GrilRepository;
import com.dubo.service.GirlService;
import com.dubo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final  static Logger logger= LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GrilRepository grilRepository;
    @Autowired
    private GirlService girlService;

    public void setGrilRepository(GrilRepository grilRepository) {
        this.grilRepository = grilRepository;
    }

    @GetMapping("/gril")
    public List<Girl> getList(){
        return grilRepository.findAll();
    }

    @PostMapping("/girls")
    public Object insertGirl(@Valid Girl girl, BindingResult bindingResult){
        Result result=new Result();
        if(bindingResult.hasErrors()){
            return ResultUtil.error(400,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(grilRepository.save(girl));
    }
    @GetMapping("/girls/{id}")
    public Girl getGirl(@PathVariable("id")Integer id){
        System.out.println("what's happen?");
        return grilRepository.findOne(id);
    }
    @DeleteMapping("/girls/{id}")
    public void deleteGirl(@PathVariable("id")Integer id){
         grilRepository.delete(id);
    }
    @PostMapping("/girls/{id}")
    public Girl update(@PathVariable("id")Integer id,String cupSize,String name,int age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setName(name);
        girl.setAge(age);
        return grilRepository.save(girl);
    }
    @PostMapping("/grils/two")
    public void two(){
        girlService.insertTwo();
    }
    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable Integer id) throws Exception {
        girlService.getAge(id);
    }
}
