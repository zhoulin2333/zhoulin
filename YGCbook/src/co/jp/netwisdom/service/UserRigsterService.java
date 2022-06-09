package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.netwisdom.dto.UserRigsterDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

@Service
public class UserRigsterService {
	//3得到mapper
	@Autowired
	UserinfoMapper userinfoMapper;
	@Autowired
	HobbyMapper hobbyMapper;
	
	public  boolean  userRigster(UserRigsterDto dto){
		String[] hobbyArray = dto.getHobby(); 
		List<Hobby> hobbyList = new ArrayList<>();
		
		for(int i=0;i<hobbyArray.length;i++){
			 
			Hobby hobby1 = new Hobby();
			hobby1.setUsername(dto.getUsername());
			hobby1.setHobby(hobbyArray[i]);
			hobbyList.add(hobby1);
		}
	    boolean successFlag = false;
    	try{

	    	//4发出请求，执行数据库操作
	    	userinfoMapper.save(new Userinfo(dto.getUsername(),dto.getPassword(),dto.getSex(),dto.getMajor(),dto.getIntro()));
	    	for(Hobby hobby : hobbyList){
	    		hobbyMapper.save(hobby.getUsername(), hobby.getHobby(),"0");
	    	}
	    	successFlag = true;
    	}catch (Exception e) {
    		successFlag = false;
    		System.out.print("抓到错误");
		}
        return successFlag;
	}
}
