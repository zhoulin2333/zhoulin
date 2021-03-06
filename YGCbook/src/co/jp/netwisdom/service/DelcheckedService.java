package co.jp.netwisdom.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.netwisdom.dto.DelcheckedDto;
import co.jp.netwisdom.mapper.HobbyMapper;
import co.jp.netwisdom.mapper.UserinfoMapper;

@Service
public class DelcheckedService {
	//3得到mapper
	@Autowired
	HobbyMapper hobbyMapper ;
	@Autowired
	UserinfoMapper userinfoMapper;
	public void delchecked(DelcheckedDto dto){

		for(String username : dto.getUsernames()){
	    	userinfoMapper.delUserinfo(username);
	    	hobbyMapper.delHobby(username);
		}
	}
}