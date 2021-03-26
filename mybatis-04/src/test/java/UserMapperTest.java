import com.cyp.dao.UserMapper;
import com.cyp.pojo.User;
import com.cyp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void  test(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        List<User> list = mapper.getUsers();
//        for (User user : list){
////            System.out.println(user);
////        }
        User user = mapper.getUserById(1);
        System.out.println(user);


         sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int a = mapper.addUser(new User(5,"绿哥","12345"));
        System.out.println(a);

//         mapper.updateUser(new User(1,"to","12333"));
//        System.out.println(a);
//        mapper.deleteUser(1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(1);
        sqlSession.commit();
        sqlSession.close();
    }
}
