package cn.key.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import cn.key.entity.BookInfo;
import co.jp.netwisdom.dto.UserNameDto;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserNameMapping implements IResultSetMapping{

	@Override
	public UserNameDto mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserNameDto username= new UserNameDto(rs.getString(i++));
		return username;
	}
	
}
