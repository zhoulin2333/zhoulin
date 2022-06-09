package co.jp.netwisdom.service;


import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.jp.netwisdom.dto.UserDelDto;
import co.jp.netwisdom.dto.UserNameDto;

import co.jp.netwisdom.mapper.UserinfoMapper;
import co.jp.netwisdom.utils.MyBatisUtil;



public class UsernameCheckService {
	public  List<UserNameDto> usernameCheck(UserDelDto dto){
        List<UserNameDto> userNameDto = new ArrayList<>();
    	//1得到 session工厂
    	SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    	//2得到session 
    	SqlSession sqlSession = sqlSessionFactory.openSession();
     	try{
	    	//3得到mapper
     		UserinfoMapper userinfoMapper = sqlSession.getMapper(UserinfoMapper.class);
	    	//4发出请求，执行数据库操作
     		userNameDto = userinfoMapper.findName(dto.getUsername());
	    	//需要提交
	    	sqlSession.commit();
    	}catch (Exception e) {
    		sqlSession.rollback();
    		System.out.print("抓到错误");
		}finally {
			sqlSession.close();
		}
		return userNameDto;
	}
}