package com.service.imp;

import com.entity.StudentDTO;
import com.mapper.StuInfoMapper;
import com.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author pengjw
 * @Title: StudentServiceimpl
 * @ProjectName demo
 * @Description: TODO
 * @date 2018/7/1310:41
 *
 */

@Service("StudentService")
public class StudentServiceimpl implements StudentService {

    @Resource
    StuInfoMapper stuInfoMapper;
    @Autowired
    redisTeplateImpl redisTepmlate;


    private static final Logger logger = LogManager.getLogger(StudentServiceimpl.class);

    @Override
    public StudentDTO getStudentDTOBystuNo(@Param(value = "stuNo") String stuNo) {
        return stuInfoMapper.getStudentDTOBystuNo(stuNo);
    }

    @Override
    public int updateStudentInfo(StudentDTO studentDTO) {
        logger.info("开始插入学生");
        try {
            redisTepmlate.addSno(studentDTO.getStuNo(), studentDTO.getStuName());
            return stuInfoMapper.updateStudentInfo(studentDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}