package com.guozz.test.practisemybatis.dao;

import com.guozz.test.practisemybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-9
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class TestMain {

    public static void main(String [] args)throws Exception{
        String resouce = "conf.xml";
        InputStream is = Resources.getResourceAsStream(resouce);
        // 构建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        User user;
        try {
            /**
             * 第一种方式: 直接执行已映射的 SQL 语句
             */
            String statement = TestMain.class.getName()+".getById";
            user = session.selectOne(statement, 1);
            System.out.println(user);
        }
        finally {
            session.close();
        }



    }
}
