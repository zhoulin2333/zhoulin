package co.jp.netwisdom.utils;


import java.io.InputStream;


import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	    public static  SqlSessionFactory sqlSessionFactory = null;
	    private MyBatisUtil(){
	    }
	    
	    
	    public static SqlSessionFactory getSqlSessionFactory(){
	        InputStream  inputStream = null;
	        if(null == sqlSessionFactory){
	        	String resource = "MyBatis-config.xml";
	        	try{
	        		inputStream = Resources.getResourceAsStream(resource);
	        		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
	        		return sqlSessionFactory;
	        	}catch (Exception e) {
					System.err.println(e);
					e.getStackTrace();
				}
	        }
	      return sqlSessionFactory;
	    }
}
