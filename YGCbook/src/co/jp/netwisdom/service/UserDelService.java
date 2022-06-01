package co.jp.netwisdom.service;



import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserinfoDAO;
import co.jp.netwisdom.dto.UserDelDto;


public class UserDelService {
	private HobbyDAO hobbyDAO = new HobbyDAO();
	private UserinfoDAO userinfoDAO = new UserinfoDAO();
	
	public void userDel(UserDelDto dto){

		HobbyDAO hobbyDAO = new HobbyDAO();
		
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		//用户信息表更新
		//boolean result = dao.save(new Userinfo(userName,passWord,sex,major,intro));
		//用户更新表Flag
	    boolean updateUserInfoFlag = true;
	    //用户信息表论理删除
	    updateUserInfoFlag = userinfoDAO.delUserinfo(dto.getUsername());
	  

        if(updateUserInfoFlag){
        	System.out.println("用户信息表删除成功");
        }else{
        	System.out.println("用户信息表删除失败");
        }
        
		//用户hobby更新表Flag
	    boolean updateHobbyFlag = true;
	    //用户hobby表论理删除
	    updateHobbyFlag = hobbyDAO.delHobby(dto.getUsername());
        if(updateHobbyFlag){
        	System.out.println("用户信息表删除成功");
        }else{
        	System.out.println("用户信息表删除失败");
        }
	}
}