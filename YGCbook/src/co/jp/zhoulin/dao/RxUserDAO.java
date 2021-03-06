package co.jp.zhoulin.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.mapping.BookInfoMapping;
import cn.key.mapping.ZlUserHobbyMapping;
import co.jp.zhoulin.dto.ZLUserHobbyDto;
import co.jp.zhoulin.entity.RxUser;

public class RxUserDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
	
	public boolean save(RxUser uxUser) {
		
		
		
		int row = 0;
		String sql = "insert into userinfo(username,password,sex,major,intro)" +
						" values(?,?,?,?,?)";
		//将传入进来的值整合为一个数组
		Object[] values = new Object[]{uxUser.getUsername(), 
				uxUser.getPassword(), 
				uxUser.getSex(),
				uxUser.getMajor(),
				uxUser.getIntro()
										};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	// 公共的 返回值为ZLUserHobby类型的List 方法名为 findNumAndHobby
	public List<ZLUserHobbyDto> findNumAndHobby(String username,String sex,String major) {
		String sql ="select userinfo.username,password,sex,major,intro,hobby from userinfo left join hobby"
				+ " on userinfo.username = hobby.username where";
	    
	    if(!"".equals(username)){
	    	sql = sql + " userinfo.username = '" + username +"' and";
	    }
		sql = sql + " sex = '" + sex + "'";
		if(!"".equals(major)){
			sql =sql + " and major = '" + major +"'"; 
		}
		
		
		List<ZLUserHobbyDto> list = new Vector<ZLUserHobbyDto>();
		try {
			list = template.selete(sql, new ZlUserHobbyMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

}

