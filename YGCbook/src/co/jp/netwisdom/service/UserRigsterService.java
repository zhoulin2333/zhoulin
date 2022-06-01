package co.jp.netwisdom.service;

import java.util.ArrayList;
import java.util.List;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.UserRigsterDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;


public class UserRigsterService {
	private HobbyDAO hobbyDAO = new HobbyDAO();
	private UserinfoDAO userinfoDAO = new UserinfoDAO();

	public  boolean  userRigster(UserRigsterDto dto){
		String[] hobbyArray = dto.getHobby(); 
		List<Hobby> hobbyList = new ArrayList<>();
		
		for(int i=0;i<hobbyArray.length;i++){
			 
			Hobby hobby1 = new Hobby();
			hobby1.setUsername(dto.getUsername());
			hobby1.setHobby(hobbyArray[i]);
			hobbyList.add(hobby1);
		}
	    boolean successFlag = true;
		//用户信息表登录
        if(userinfoDAO.save(new Userinfo(dto.getUsername(),dto.getPassword(),dto.getSex(),dto.getMajor(),dto.getIntro()))){
        	System.out.println("用户信息表插入成功");
        }else{
        	System.out.println("用户信息表插入失败");
        	successFlag =  false;
        }
        //用户爱好表登录
        if(hobbyDAO.save(hobbyList)){
        	System.out.println("用户爱好表插入成功");
        }else{
        	System.out.println("用户爱好表插入失败");
        	successFlag =  false;
        }
        return successFlag;
	}
}
