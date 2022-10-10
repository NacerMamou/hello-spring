package com.nmamou.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nmamou.hellospring.Grade;
import com.nmamou.hellospring.repository.GradeRepository;

@Service
public class GradeService {
  @Autowired
  GradeRepository gradeRepository;
  public Grade getGrade(int index){
    return gradeRepository.getGrade(index);
  }

  public void addGrade(Grade newGrade){
    gradeRepository.addGrade(newGrade);
  }

  public void updateGrade(Grade newGradeValue, Integer index){
    gradeRepository.updateGrade(newGradeValue, index);
  }

  public List <Grade> getAllGrades(){
    return gradeRepository.getAllGrades();
  }

  public Grade getGradeById(String id){
    Integer index = getGradeIndex(id);
    return index == -1000 ? new Grade() : getGrade(index);
  }

  public void removeGrade(int index){
    gradeRepository.removeGrade(index);
  }

  public Integer getGradeIndex(String id){
    for(int i=0; i < gradeRepository.getAllGrades().size(); i++){
      if( gradeRepository.getGrade(i).getId().equals(id))
        return i;
    }
    return -1000;
  }
}
