package co.jp.netwisdom.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.netwisdom.dto.UserDelDto;
import co.jp.netwisdom.dto.UserNameDto;

import co.jp.netwisdom.mapper.UserinfoMapper;


@Service
public class UsernameCheckService {
	//3得到mapper
	@Autowired
    UserinfoMapper userinfoMapper;
	public  List<UserNameDto> usernameCheck(UserDelDto dto){
        List<UserNameDto> userNameDto = new ArrayList<>();

	   //4发出请求，执行数据库操作
        userNameDto = userinfoMapper.findName(dto.getUsername());
	   //需要提交
	   return userNameDto;
	}
}