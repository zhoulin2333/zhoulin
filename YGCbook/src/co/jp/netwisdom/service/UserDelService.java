package co.jp.netwisdom.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.netwisdom.dto.UserDelDto;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

@Service
public class UserDelService {
	//3得到mapper
	@Autowired
	UserinfoMapper userinfoMapper ;
	@Autowired
	HobbyMapper hobbyMapper ;
	
	public void userDel(UserDelDto dto){
	    	//4发出请求，执行数据库操作
	    	userinfoMapper.delUserinfo(dto.getUsername());
	    	hobbyMapper.delHobby(dto.getUsername());
	    	//需要提交
	}
}