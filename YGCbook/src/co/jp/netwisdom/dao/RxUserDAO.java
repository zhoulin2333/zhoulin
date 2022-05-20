package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.mapping.BookInfoMapping;
import co.jp.netwisdom.entity.RxUser;

public class RxUserDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
	
	public boolean save(RxUser uxUser) {
		
		
		
		int row = 0;
		String sql = "insert into userinfo(username,password,sex,major,intro)" +
						" values(?,?,?,?,?)";
		//将传入进来的值整合为一个数组
		Object[] values = new Object[]{uxUser.getUsername(), uxUser.getPassword(), uxUser.getSex(),uxUser.getMajor(),uxUser.getIntro(),
				                       
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
	

}
