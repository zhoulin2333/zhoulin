package co.jp.netwisdom.service;


import java.util.ArrayList;
import java.util.List;




import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.UserUpdateDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;


public class UserUpdateService {
	private UserinfoDAO userinfoDAO = new UserinfoDAO();
	private HobbyDAO hobbyDAO = new HobbyDAO();
	
	public void userUpdate(UserUpdateDto dto){
		//爱好 TODO
		String[] hobbyArray = dto.getHobbyArray();

		List hobbyList = new ArrayList();
		
		for(int i=0;i<hobbyArray.length;i++){
			 
			Hobby hobby1 = new Hobby();
			hobby1.setUsername(dto.getUsername());
			hobby1.setHobby(hobbyArray[i]);
			hobbyList.add(hobby1);
			
		}	
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		HobbyDAO hobbyDAO = new HobbyDAO();
		
		//用户更新表Flag
	    boolean updateUserInfoFlag1 = true;
	    //用户信息表论理删除
	    updateUserInfoFlag1 = userinfoDAO.delUserinfo(dto.getUsername());
	    
	    boolean updateUserInfoFlag2 = true;
	    //进行更新操作
	    updateUserInfoFlag2 = userinfoDAO.save(new Userinfo(dto.getUsername(),dto.getPassword(),dto.getSex(),dto.getMajor(),dto.getIntro()));

        if(updateUserInfoFlag1==true && updateUserInfoFlag2 == true){
        	System.out.println("用户信息表更新成功");
        }else{
        	System.out.println("用户信息更新失败");
        }
		//用户hobby更新表Flag
	    boolean updateHobbyFlag = true;
	    //用户hobby表论理删除
	    updateHobbyFlag = hobbyDAO.delHobby(dto.getUsername());
	    //进行更新操作
	    updateHobbyFlag = hobbyDAO.save(hobbyList);
        if(updateHobbyFlag=true){
        	System.out.println("用户信息表更新成功");
        }else{
        	System.out.println("用户信息更新失败");
        }
	}
}