package com.cyp.dao;

import com.cyp.pojo.User;
import com.cyp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {
    SqlSession session = MybatisUtils.getSession() ;

    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        session.close();
    }

//    @Test
//    public  void testLog4j(){
//         logger.info("info:进入了testLog4j");
//        logger.debug("debug:进入了testLog4j");
//        logger.error("error:进入了testLog4j");
//    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> list = mapper.getUserByLimit(map);
        for (User user:list){
            System.out.println(user);
        }
        sqlSession.close();
    }
}
