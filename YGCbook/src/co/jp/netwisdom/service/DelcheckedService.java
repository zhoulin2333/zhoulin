package co.jp.netwisdom.service;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.DelcheckedDto;


public class DelcheckedService {
	private HobbyDAO hobbyDAO = new HobbyDAO();
	private UserinfoDAO userinfoDAO = new UserinfoDAO();
	
	public void delchecked(DelcheckedDto dto){

		for(String username : dto.getUsernames()){

				//用户更新表Flag
			    boolean updateUserInfoFlag = true;
			    //用户信息表论理删除
			    updateUserInfoFlag = userinfoDAO.delUserinfo(username);
			  
		
		        if(updateUserInfoFlag){
		        	System.out.println("用户信息表删除成功");
		        }else{
		        	System.out.println("用户信息表删除失败");
		        }
		        
				//用户hobby更新表Flag
			    boolean updateHobbyFlag = true;
			    //用户hobby表论理删除
			    updateHobbyFlag = hobbyDAO.delHobby(username);
		        if(updateHobbyFlag){
		        	System.out.println("用户hobby表删除成功");
		        }else{
		        	System.out.println("用户hobby表删除失败");
		        }
		}
	}
}