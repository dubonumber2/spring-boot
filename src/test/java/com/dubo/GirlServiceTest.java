package com.dubo;

import com.dubo.entity.Girl;
import com.dubo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void getOne(){
        Assert.assertEquals(new Integer(12),(Integer) girlService.getOne(13).getAge());

    }
}
