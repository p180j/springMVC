package com.controller;

import com.entity.StudentDTO;
import com.service.StudentService;
import com.service.imp.StudentServiceimpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author pengjw
 * @Title: StudentInfoController
 * @ProjectName demo
 * @Description: 学生功能类
 * @date 2018/7/1310:31
 */
@Controller
@RequestMapping("/stuInfo")
public class StudentInfoController {
    @Autowired
    StudentService studentService;

    private static final Logger logger = LogManager.getLogger(StudentInfoController.class);
    /**
     * 根据学生学号获得学生信息
     * @return
     */
    @RequestMapping("/getStuBystuNo.do")
    public ModelAndView getStudentDTOBystuNo(HttpServletRequest request, HttpServletResponse response){
        logger.info("进入controller控制器");
        String no=request.getParameter("stuNo");
        String a ="{\"merchantCode\":\"TESTCODE2\",\n" +
                "\"serialNo\":\"1234567q345678f\",\n" +
                "\"bizType\":\"106\",\n" +
                "\"operationType\":\"01\",\t\n" +
                "\"bizList\":[\t\n" +
                "\t{\"bizNo\":\"13456787654345\",\"otherNo\":\"10\",\"operationRet\":\"\",\"remark1\":\"皮皮1\",\"remark2\":\"皮皮2\"},\n" +
                "\t{\"bizNo\":\"13456787654346\",\"otherNo\":\"9\",\"operationRet\":\"\",\"remark1\":\"皮皮3\",\"remark2\":\"皮皮4\"}\n" +
                "]\n" +
                "}";
        logger.info("学号是no："+no);
        Enumeration<String> paraNames = request.getParameterNames();
        Map<String, String> resultMap = new TreeMap<String, String>();
        while (paraNames.hasMoreElements()) {
            String key = paraNames.nextElement();
            String value = request.getParameter(key);
            if (value!=null&&value!="") {
                continue;
            }
            resultMap.put(key, value);
        }
     String stuNo=  resultMap.get("stuNo");
        System.out.println("学号是："+stuNo);
        StudentDTO studentDTO=new StudentDTO();
        //StudentDTO studentDTO =studentService.getStudentDTOBystuNo(no);
        studentDTO.setStuNo("2018006");
        studentDTO.setStuName("皮皮");
        studentDTO.setCno("11111");
        studentDTO.setScore("98");
        int flag=studentService.updateStudentInfo(studentDTO);
        System.out.println("flag="+flag);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("helloWord");
        return mv;

    }


}
