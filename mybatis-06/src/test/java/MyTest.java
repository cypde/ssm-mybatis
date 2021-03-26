import com.cyp.dao.TeacherMapper;

import com.cyp.pojo.Teacher;
import com.cyp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test111(){
        SqlSession sqlSession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        for (Teacher teacher:mapper.getTeacher()){
            System.out.println(teacher);
        }
        sqlSession.close();
    }
}
