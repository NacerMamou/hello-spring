package com.nmamou.hellospring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nmamou.hellospring.Grade;

@Component
public class GradeRepository {
  private List <Grade> studentGrades = new ArrayList<>(); 

  public Grade getGrade(int index){
    return studentGrades.get(index);
  }

  public void addGrade(Grade newGrade){
    studentGrades.add(newGrade);
  }

  public void updateGrade(Grade newGradeValue, Integer index){
    studentGrades.set(index, newGradeValue);
  }

  public List<Grade> getAllGrades(){
    return studentGrades;
  }

  public void removeGrade(int index){
    studentGrades.remove(index);
  }
}
