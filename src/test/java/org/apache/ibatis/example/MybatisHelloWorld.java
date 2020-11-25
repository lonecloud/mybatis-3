package org.apache.ibatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author lonecloud
 * @version v1.0
 * @Package org.apache.ibatis.example
 * @Description: TODO
 * @date 2020/11/242:09 PM
 */
public class MybatisHelloWorld {
  public static void main(String[] args) {
    String resource = "org/mybatis/internal/example/Configuration.xml";
    Reader reader;
    try {
      reader = Resources.getResourceAsReader(resource);
      SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

      SqlSession session = sqlMapper.openSession();
      try {
        User user = (User) session.selectOne("org.mybatis.internal.example.mapper.UserMapper.getUser", 1);
        System.out.println(user.getLfPartyId() + "," + user.getPartyName());
      } finally {
        session.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
