package co.jp.netwisdom.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.netwisdom.dto.HobbyDto;

import co.jp.netwisdom.dto.UserSearchDto;
import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;
import co.jp.netwisdom.mapper.UserinfoMapper;
@Service
public class UserSearchService {
	//3得到mapper
	@Autowired
	UserinfoMapper userinfoMapper;
	
	public List<UserinfoHobbyDto> UserSearch(UserSearchDto dto){
		
		List<UserinfoHobby> list = new ArrayList<>();


	    //4发出请求，执行数据库操作
        list = userinfoMapper.findUserinfoAndHobby(dto.getUsername(), dto.getSex(), dto.getMajor());
		List<UserinfoHobbyDto> dtos = new ArrayList<UserinfoHobbyDto>();
		
		//标识dtos是否被创建
		List<String> userNames =  new ArrayList<String>();
		
		
		System.out.println("用户信息如下：");
		for(UserinfoHobby userinfoHobby: list ){

			//当用户名不存在时，证明大的dtos未创建
			if(!userNames.contains(userinfoHobby.getUsername())){
				UserinfoHobbyDto uhdto =new UserinfoHobbyDto(userinfoHobby.getUsername(),userinfoHobby.getPassword(),
						userinfoHobby.getSex(),userinfoHobby.getMajor(),
						userinfoHobby.getIntro());
				//将创建的大的dtos加到画面展示list里去
				dtos.add(uhdto);
				//将用户名加到userNames中
				userNames.add(userinfoHobby.getUsername());
				//将爱好加进子dto中
				if(userinfoHobby.getHobby() != null){
					uhdto.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
				}
				
			}else{
				for(UserinfoHobbyDto temp : dtos){
					//如果当前对象的名字等于传入进来的名字时
					if(temp.getUsername().equals(userinfoHobby.getUsername())){
						if(userinfoHobby.getHobby() != null){
							//将重复姓名的爱好加入子dto中
							temp.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
						}
					}
				}
			}
		 }
		
		for(UserinfoHobbyDto result : dtos){
			System.out.println("-------------------");
			System.out.println("姓名：" + result.getUsername());
			System.out.println("密码：" + result.getPassword());
			System.out.println("性别：" + result.getSex());
			System.out.println("专业：" + result.getMajor());
			System.out.println("简介：" + result.getIntro());
			System.out.print("爱好：");
			StringBuffer sb = new  StringBuffer ("");
			for(HobbyDto hobbyDto : result.getHobbyList()){
				if(hobbyDto.getHobby() != null){
					sb.append(hobbyDto.getHobby() + ",");	
				}
			}
			//当有爱好时才截取操作
			if(!"".equals(sb.toString())){
				if(",".equals(sb.toString().substring(sb.toString().length()-1))){
					System.out.println(sb.toString().substring(0, sb.toString().length()-1));
					
				}else{
					System.out.println(sb.toString());
				}
				
			}
		}
		return dtos;
	}
}
