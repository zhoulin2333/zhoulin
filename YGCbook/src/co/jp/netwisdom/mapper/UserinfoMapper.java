package co.jp.netwisdom.mapper;

import java.util.List;

import co.jp.netwisdom.dto.UserNameDto;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.entity.UserinfoHobby;

public interface UserinfoMapper {
	public  void save(Userinfo userinfo);
	public void delUserinfo(String username);
	public List<UserinfoHobby> findUserinfoAndHobby(String username,String sex,String major);
	public List<UserinfoHobby> findUserAndHobby(String username);
	public List<UserNameDto> findName(String username);
}
