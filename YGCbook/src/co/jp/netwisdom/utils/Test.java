package co.jp.netwisdom.utils;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.jp.netwisdom.dto.UserNameDto;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;


public class Test {
	    public static void main(String[] args) {
	    	//1得到 session工厂
	    	SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	    	//2得到session 
	    	SqlSession sqlSession = sqlSessionFactory.openSession();
	     	try{
		    	//3得到mapper
	     		UserinfoMapper userinfoMapper = sqlSession.getMapper(UserinfoMapper.class);
		    	//4发出请求，执行数据库操作
	     		List<UserNameDto> list = userinfoMapper.findName("zhoulin");
		    	//需要提交
		    	sqlSession.commit();
		    	System.out.println(list.size());
	    	}catch (Exception e) {
	    		sqlSession.rollback();
	    		System.out.print("抓到错误");
			}finally {
				sqlSession.close();
			}
		
//	    	try{
//		    	//3得到mapper
//		    	HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
//		    	//4发出请求，执行数据库操作
//		    	hobbyMapper.save("vvvvv", "1", "0");
//		    	//需要提交
//		    	sqlSession.commit();
//	    	}catch (Exception e) {
//	    		sqlSession.rollback();
//	    		System.out.print("抓到错误");
//			}finally {
//				sqlSession.close();
//			}
	   }

}
