package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.mapping.BookInfoMapping;
import cn.key.mapping.USerInfoMapping;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserinfoDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
	
	
	public boolean save(Userinfo userinfo) {
		int row = 0;
		String sql = "insert into userinfo(username,password,sex,major,intro) " +
						" values(?,?,?,?,?)";
		
		Object[] values = new Object[]{
				        userinfo.getUsername(), 
				        userinfo.getPassword(),
				        userinfo.getSex(),
				        userinfo.getMajor(),
				        userinfo.getIntro()};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	
	
	public List<UserinfoHobby> findUserinfoAndHobby(String username,String sex,String major) {
  		String sql = "select  userinfo.username,password,sex,major,intro,hobby"
				   + " from userinfo left join hobby"
	               + " on userinfo.username = hobby.username where" ;
		
		if (!"".equals(username)){
			sql = sql + " username = '"+ username +"' and";
		}
			sql = sql + " sex ='" + sex +"'";		
			
		if (!"".equals(major)){
			sql = sql + " and major = '"+ major +"'";
		}
		List<UserinfoHobby> list = new Vector<UserinfoHobby>();
		try {
			list = template.selete(sql, new USerInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	} 
}
	
	
	