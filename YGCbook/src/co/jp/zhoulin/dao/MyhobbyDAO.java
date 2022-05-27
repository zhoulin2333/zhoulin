package co.jp.zhoulin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.mapping.BookInfoMapping;

import co.jp.zhoulin.entity.Myhobby;

public class MyhobbyDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
	
	public boolean save(List<Myhobby> list) {
		int row = 0;
		String sql =  "insert into hobby(username,hobby) " +
				      " values(?,?)";
		
		try {
			
		    for(Myhobby myhobby : list){
		    	
		    	
			    Object[] values = new Object[]{myhobby.getHobby(),myhobby.getUsername()};
			    row = template.updata(sql, values);
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	


}

