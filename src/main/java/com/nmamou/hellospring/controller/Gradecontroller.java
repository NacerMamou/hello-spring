package com.nmamou.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nmamou.hellospring.Grade;
import com.nmamou.hellospring.repository.GradeRepository;

@Controller
public class Gradecontroller {
  GradeRepository gradeRepository = new GradeRepository();
    
 

  @GetMapping("/grades")
  public String getGrades(Model model){
    model.addAttribute("grades", gradeRepository.getAllGrades());
    return "grades";
  }

  @GetMapping("/")
  public String getForm(Model model, @RequestParam(required=false) String id){
    Integer index = getIndex(id);
    model.addAttribute("grade", index == -1000 ? new Grade() : gradeRepository.getGrade(index));
    return "form";
  }

  public Integer getIndex(String id){
    for(int i=0; i < gradeRepository.getAllGrades().size(); i++){
      if( gradeRepository.getGrade(i).getId().equals(id))
        return i;
    }
    return -1000;
  }

  @PostMapping("/handleSubmit")
  public String submitGrade(Grade grade, Model model){
    int index = getIndex(grade.getId());
    if(index == -1000){
      gradeRepository.addGrade(grade);
    }else{
      gradeRepository.updateGrade(grade, index);
    }  
    model.addAttribute("grades", gradeRepository.getAllGrades());
    return "redirect:/grades";
  }
}


