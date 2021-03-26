import com.cyp.dao.StudentMapper;
import com.cyp.dao.TeacherMapper;
import com.cyp.pojo.Student;
import com.cyp.pojo.Teacher;
import com.cyp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent();

        for (Student student : studentList){
            System.out.println(student);
        }
        sqlSession.commit();
        sqlSession.close();

    }

}
