package org.apache.ibatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author lonecloud
 * @version v1.0
 * @Package org.apache.ibatis.example
 * @Description: TODO
 * @date 2020/11/242:09 PM
 */
public class MybatisHelloWorld {
  public static void main(String[] args) {
    String resource = "Configuration.xml";
    Reader reader;
    try {
      reader = Resources.getResourceAsReader(resource);
      SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

      SqlSession session = sqlMapper.openSession();
      try {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List list = mapper.query(
          new BigDecimal("120.003446"), new BigDecimal("120.003446"), new BigDecimal("30.280146"), new BigDecimal("30.280146"), 100
        );
        System.out.println(list);
      } finally {
        session.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
