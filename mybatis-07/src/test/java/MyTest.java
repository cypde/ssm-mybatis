import com.cyp.dao.BlogMapper;
import com.cyp.pojo.Blog;
import com.cyp.utils.IDUtils;
import com.cyp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
     public void addInitBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.commit();
        session.close();
    }
    @Test
    public void queryBlogIF(){
       SqlSession sqlSession = MybatisUtils.getSession();
       BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

       HashMap map = new HashMap();
         map.put("title","Java如此简单");
//         map.put("author","狂神说");
       List<Blog> blogs = mapper.queryBlogIF(map);

       for (Blog blog :
               blogs) {
          System.out.println(blog);
       }
    }

    @Test
    public void queryBlogIF2() {
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "Java如此简单");
//         map.put("author","狂神说");
         map.put("views",999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog :
                blogs) {
            System.out.println(blog);
        }


        sqlSession.close();

    }


    @Test
    public void queryBlogIF3() {
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Mybatis如此简单22");
        map.put("author","狂神说");
        map.put("id","b60865e4d4844db5a92c44d5185ff9b7");

        mapper.updateBlog(map);

        sqlSession.commit();
        sqlSession.close();

    }
}
