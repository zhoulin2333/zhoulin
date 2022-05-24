package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.mapping.BookInfoMapping;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.Userinfo;

public class HobbyDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
	
	
	public boolean save(List list) {
		int row = 0;
		String sql = "insert into hobby(username,hobby,delFlg) " +
						" values(?,?,?)";
		
		try {
		    for(Object object:list){

				   Hobby hobby = (Hobby)object; 
				   Object[] values = null;
				   
				   values = new Object[]{
							hobby.getUsername(), 
							hobby.getHobby(),
							"0"};
							row = template.updata(sql, values);
            	  if(row == 0){
            		        break;
            	  }
		    }		     
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	/**
	 * 伦理删除
	 * @param userinfo
	 * @return
	 */
	public boolean delHobby(String username) {
		
		String sql = "update hobby set delFlg = '1' where username = ?";

		Object[] values = new Object[]{
				        username};
		try {
			template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
}

	
	
	