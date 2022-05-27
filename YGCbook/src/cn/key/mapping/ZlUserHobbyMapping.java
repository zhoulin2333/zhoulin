package cn.key.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import cn.key.entity.BookInfo;
import co.jp.zhoulin.dto.ZLUserHobbyDto;

public class ZlUserHobbyMapping implements IResultSetMapping{

	@Override
	public ZLUserHobbyDto mapping(ResultSet rs) throws SQLException {
		int i = 1;
		ZLUserHobbyDto zLUserHobby = new ZLUserHobbyDto(rs.getString(i++), 
												  rs.getString(i++), 
												  rs.getString(i++), 
												  rs.getString(i++),
												  rs.getString(i++), 
												  rs.getString(i++));
		return zLUserHobby;
	}
	
}
