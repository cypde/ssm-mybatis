package com.cyp.dao;

import com.cyp.pojo.Student;
import com.cyp.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

     List<Student> getStudent();

     List<Student> getStudent2(int id);
}
