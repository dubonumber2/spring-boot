package com.dubo.service;

import com.dubo.entity.Girl;
import com.dubo.enums.ResultEnum;
import com.dubo.exception.GirlException;
import com.dubo.repository.GrilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GrilRepository grilRepository;

    public void setGrilRepository(GrilRepository grilRepository) {
        this.grilRepository = grilRepository;
    }
    @Transactional
    public void insertTwo(){
        Girl a=new Girl();
        a.setAge(18);
        a.setName("黑山");
        a.setCupSize("G");
        grilRepository.save(a);
        String a1=null;
       // System.out.println(a1.toString());
        Girl b=new Girl();
        b.setAge(20);
        b.setName("黑山1");
        b.setCupSize("G1");
        grilRepository.save(b);
    }

    public void getAge(Integer id) throws Exception {
       Girl girl = grilRepository.findOne(id);
       Integer age=girl.getAge();
       if(age<10){
            //你还在上小学吧
           throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
       }else if(age>10&&age<16){
           //你还在上初中吧
           throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
       }

    }

    public Girl getOne(Integer id){
      return  grilRepository.findOne(id);
    }
}
