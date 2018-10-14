package com.mapper;

import com.entity.StudentDTO;




public interface StuInfoMapper {

   StudentDTO getStudentDTOBystuNo(String stuNo);

   int updateStudentInfo(StudentDTO studentDTO);
}
