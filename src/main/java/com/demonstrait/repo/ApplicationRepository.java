package com.demonstrait.repo;

import com.demonstrait.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    Application findApplicationById(Integer id);

    void deleteApplicationById(Integer id);


}
