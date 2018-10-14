package com.service;

import com.entity.StudentDTO;

public interface StudentService {

   StudentDTO getStudentDTOBystuNo(String stuNo); //根据学号获取学生信息

   int  updateStudentInfo (StudentDTO studentDTO) ;
}
