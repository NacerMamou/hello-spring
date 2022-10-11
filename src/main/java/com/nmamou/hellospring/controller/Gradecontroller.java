package com.nmamou.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nmamou.hellospring.Grade;
import com.nmamou.hellospring.service.GradeService;

@Controller
public class GradeController {

  // This added to eliminate tight Coupling
  @Autowired
  GradeService gradeService;
    

  @GetMapping("/grades")
  public String getGrades(Model model){
    model.addAttribute("grades", gradeService.getAllGrades());
    return "grades";
  }

  @GetMapping("/")
  public String getForm(Model model, @RequestParam(required=false) String id){
    model.addAttribute("grade", gradeService.getGradeById(id));
    return "form";
  }

  @GetMapping("/delete")
  public String getDelete(Model model, @RequestParam(required=false) String id){
    gradeService.removeGrade(gradeService.getGradeIndex(id));
    // You do not need to give the model attribute in here because a rederiction will be performed
    // The redirection will give the model attribute
    // model.addAttribute("grades", gradeService.getAllGrades());
    return "redirect:/grades";
  }

  @PostMapping("/handleSubmit")
  public String submitGrade(Grade grade){
    int index = gradeService.getGradeIndex(grade.getId());
   
    if(index == -1000){
      gradeService.addGrade(grade);
    }else{
      gradeService.updateGrade(grade, index);
    }  
    // You do not need to give the model attribute in here because a rederiction will be performed
    // The redirection will give the model attribute
    // model.addAttribute("grades", gradeService.getAllGrades());
    return "redirect:/grades";
  }
}


