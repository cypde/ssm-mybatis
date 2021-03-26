package com.cyp.dao;

import com.cyp.pojo.User;
import com.cyp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    SqlSession session = MybatisUtils.getSession() ;
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> usersList = mapper.getUserLike("%狂%");
        for(User user:usersList) {
            System.out.println(user);
        }
        session.close();
    }


    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession() ;

        try{
            session = MybatisUtils.getSession();
            //方法一(过时）:
//        List<User> users = session.selectList("com.cyp.dao.UserMapper.selectUser");
            //方法二:
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectUser();

            for (User user: users){
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    //查询
    public  void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    //查询
    public  void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String, Object>();
        map.put("helloId",1);
        map.put("name","狂神");
        User user = mapper.getUserById2(map);
        System.out.println(user.getPwd());
        session.close();
    }

    @Test
    public  void addUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4,"哈哈","1233333"));
        if(res>0){
            System.out.println("插入成功");
        }
        //提交事务,漏掉则不行
        sqlSession.commit();
        session.close();
    }

    @Test
    public  void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String, Object>();
        map.put("userid",5);
        map.put("userName","HEllo");
        map.put("passWord","23333");
        mapper.addUser2(map);
        sqlSession.commit();
        session.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        user.setPwd("asdfgh");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

}
