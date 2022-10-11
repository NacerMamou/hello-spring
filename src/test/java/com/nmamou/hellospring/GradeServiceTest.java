package com.nmamou.hellospring;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nmamou.hellospring.repository.GradeRepository;
import com.nmamou.hellospring.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
  @Mock 
  private GradeRepository gradeRepository;

  @InjectMocks
  private GradeService gradeService;

  @Test
  public void getAllGradesTest(){
    when(gradeRepository.getAllGrades()).thenReturn(Arrays.asList(
      new Grade("Nacer", "Math", "18"), 
      new Grade("Yacin", "Physics", "3"), 
      new Grade("Djafer", "Chemistry", "15"))
    );

    List<Grade> result = gradeService.getAllGrades();

    assertEquals("Nacer", result.get(0).getName());
    assertEquals("Physics", result.get(1).getSubject());
    assertEquals("15", result.get(2).getScore());
  }

  @Test 
  public void getGradeIndexTest(){
    Grade grade1 = new Grade("Nacer", "Math", "18");
    Grade grade2 = new Grade("Yacin", "Smail", "17");

    when(gradeRepository.getAllGrades()).thenReturn(Arrays.asList(grade1, grade2));
    when(gradeRepository.getGrade(0)).thenReturn(grade1);
    when(gradeRepository.getGrade(1)).thenReturn(grade2);

    List<Grade> result = gradeService.getAllGrades();
    
    int rIndex1 = gradeService.getGradeIndex(result.get(0).getId());
    int rIndex2 = gradeService.getGradeIndex(result.get(1).getId());

    assertEquals( 0, rIndex1);
    assertEquals( 1, rIndex2);
  }

  
  
  
}
