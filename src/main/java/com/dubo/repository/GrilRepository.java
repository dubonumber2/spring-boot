package com.dubo.repository;

import com.dubo.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GrilRepository extends JpaRepository<Girl,Integer>{

}
