package co.jp.netwisdom.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import co.jp.netwisdom.dto.UserUpdateDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;
import co.jp.netwisdom.utils.MyBatisUtil;


public class UserUpdateService {
	public void userUpdate(UserUpdateDto dto){
		//爱好 TODO
		String[] hobbyArray = dto.getHobbyArray();

		List<Hobby> hobbyList = new ArrayList<>();
		
		for(int i=0;i<hobbyArray.length;i++){
			 
			Hobby hobby1 = new Hobby();
			hobby1.setUsername(dto.getUsername());
			hobby1.setHobby(hobbyArray[i]);
			hobbyList.add(hobby1);
			
		}	
	   	//1得到 session工厂
    	SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    	//2得到session 
    	SqlSession sqlSession = sqlSessionFactory.openSession();
    	
    	try{
	    	//3得到mapper
    		UserinfoMapper userinfoMapper = sqlSession.getMapper(UserinfoMapper.class);
	    	HobbyMapper hobbyMapper = sqlSession.getMapper(HobbyMapper.class);
	    	//4发出请求，执行数据库操作
	    	//用户信息表论理删除
	    	userinfoMapper.delUserinfo(dto.getUsername());
	    	//更新信息表
	    	userinfoMapper.save(new Userinfo(dto.getUsername(),dto.getPassword(),dto.getSex(),dto.getMajor(),dto.getIntro()));
	    	//用户爱好表伦理删除
	    	hobbyMapper.delHobby(dto.getUsername());
	    	//更新爱好表
	    	for(Hobby hobby : hobbyList){
	    		hobbyMapper.save(hobby.getUsername(), hobby.getHobby(), "0");
	    	}
	    	//需要提交
	    	sqlSession.commit();
    	}catch (Exception e) {
    		sqlSession.rollback();
    		System.out.print("抓到错误");
		}finally {
			sqlSession.close();
		}
	}
}