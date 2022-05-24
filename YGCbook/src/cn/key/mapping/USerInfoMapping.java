package cn.key.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import cn.key.entity.BookInfo;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.entity.UserinfoHobby;

public class USerInfoMapping implements IResultSetMapping{

	@Override
	public Userinfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		Userinfo userinfo = new Userinfo(rs.getString(i++),
														rs.getString(i++), 
														rs.getString(i++), 
														rs.getString(i++), 
														rs.getString(i++));
		return userinfo;
	}
	
}
