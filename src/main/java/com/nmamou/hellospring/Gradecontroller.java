package com.nmamou.hellospring;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Gradecontroller {
  // Creating a list for template loops testing
  // List<Grade> studentGrades = new ArrayList<>(); 
  // studentGrades.add(new Grade("Hermonial", "Periodic", "C-"));
  // studentGrades.add(new Grade("Testomonial", "Plenty", "A+"));
  // studentGrades.add(new Grade("HarryKing", "Vergers", "D+"));
    
  // Or directly
  // List<Grade> studentGrades = Arrays.asList(
  //   new Grade("Hermonial", "Periodic", "C-"),
  //   new Grade("Testomonial", "Plenty", "A+"),
  //   new Grade("HarryKing", "Vergers", "D+")
  // );
    
    List<Grade> studentGrades = new ArrayList<>(); 
 

  @GetMapping("/grades")
  public String getGrades(Model model){
    // Grade grade = new Grade("Harry", "Potions", "C-");
    // model.addAttribute("grade", grade);
   
    // Grade grade1 = new Grade("Breaking Bad", "Potions", "10.0");
    // model.addAttribute("grade1", grade1);
    
    // Grade grade2 = new Grade("Attack on titan", "Potions", "9.9");
    // model.addAttribute("grade2", grade2);
    
    // Grade grade3 = new Grade("Attack on Titan", "Potions", "9.9");
    // model.addAttribute("grade3", grade3);
    
    // Grade grade4 = new Grade("Star Wars", "Potions", "9.9");
    // model.addAttribute("grade4", grade4);

    // // Conditionals Testing
    // model.addAttribute("sales", 49);

    // model.addAttribute("product", "chair");
    
    

    model.addAttribute("grades", studentGrades);


    return "grades";
  }

  @GetMapping("/")
  public String getForm(Model model, @RequestParam(required=false) String id){
    // Grade grade;
    // if(getIndex(name) == -1000){
    //   grade = new Grade();
    // }else{
    //   grade = studentGrades.get(getIndex(name));
    // }
    // model.addAttribute("grade", grade );
    model.addAttribute("grade", getIndex(id) == -1000 ? new Grade() : studentGrades.get(getIndex(id)) );



    // model.addAttribute("grade", new Grade() );
    // initialize the grade object passed to the template if you need prepopulated fields
    // model.addAttribute("grade", new Grade("Hermonial", "Periodic", "C-"));

    return "form";
  }

  public Integer getIndex(String id){
    for(int i=0; i < studentGrades.size(); i++){
      if( studentGrades.get(i).getId().equals(id))
        return i;
    }
    return -1000;
  }

  @PostMapping("/handleSubmit")
  public String submitGrade(Grade grade, Model model){
    
    int index = getIndex(grade.getId());

    if(index == -1000){
      studentGrades.add(grade);
    }else{
      studentGrades.set(index, grade);
    }  
    model.addAttribute("grades", studentGrades);
    // return "submittedgrades";
    // or use redirect whitout the need of passing a model
    return "redirect:/grades";
  }
}


