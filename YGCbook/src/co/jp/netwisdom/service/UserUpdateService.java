package co.jp.netwisdom.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.netwisdom.dto.UserUpdateDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

@Service
public class UserUpdateService {
	
	@Autowired
	UserinfoMapper userinfoMapper ;
	@Autowired
	HobbyMapper hobbyMapper ;
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
//	   	//1得到 session工厂
//    	SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
//    	//2得到session 
//    	SqlSession sqlSession = sqlSessionFactory.openSession();
    	
    
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
	
	}
}