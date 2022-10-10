package com.nmamou.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nmamou.hellospring.repository.GradeRepository;


@Configuration
public class AppConfig {
  @Bean
  public GradeRepository gradeRepository(){
    return new GradeRepository();
  }
}
