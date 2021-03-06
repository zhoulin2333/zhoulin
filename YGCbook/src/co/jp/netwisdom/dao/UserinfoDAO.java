package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.Tools.DataTool;
import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookInfo;
import cn.key.mapping.BookInfoMapping;
import cn.key.mapping.USerInfoHobbyMapping;
import cn.key.mapping.USerInfoMapping;
import cn.key.mapping.UserNameMapping;
import co.jp.netwisdom.dto.UserNameDto;
import co.jp.netwisdom.entity.Userinfo;
import co.jp.netwisdom.entity.UserinfoHobby;

public class UserinfoDAO {
	private JdbcTemplate template = new JdbcTemplate();
	private String username ;
	
	
	
	public boolean save(Userinfo userinfo) {
		int row = 0;
		String sql = "insert into userinfo(username,password,sex,major,intro,delFlg) " +
						" values(?,?,?,?,?,?)";
		
		Object[] values = new Object[]{
				        userinfo.getUsername(), 
				        userinfo.getPassword(),
				        userinfo.getSex(),
				        userinfo.getMajor(),
				        userinfo.getIntro(),
				        "0"};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	
//	public List<Userinfo> findUserinfo(String username,String sex,String major) {
//  		String sql = "select * from  userinfo where delFlg = '0' and ";
//		
//		if (!"".equals(username)){
//			sql = sql + " username = '"+ username +"' and";
//		}
//			sql = sql + " sex ='" + sex +"'";		
//			
//		if (!"".equals(major)){
//			sql = sql + " and major = '"+ major +"'";
//		}
//		
//		
//		
//		List<Userinfo> list = new Vector<Userinfo>();
//		try {
//			list = template.selete(sql, new USerInfoMapping());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	} 
//	
//	
	
	@SuppressWarnings("unchecked")
	public List<UserinfoHobby> findUserinfoAndHobby(String username,String sex,String major) {
  		String sql = "select  userinfo.username,password,sex,major,intro,hobby"
				   + " from userinfo left join hobby"
	               + " on userinfo.username = hobby.username where" ;
		
		if (username != null & !"".equals(username)){
			sql = sql + " userinfo.username = '"+ username +"' and";
		}
			sql = sql + " sex ='" + sex +"'";		
			
		if (major != null & !"".equals(major)){
			sql = sql + " and major = '"+ major +"'";
		}
		
		sql = sql + " and userinfo.delFlg = '0' and hobby.delFlg = '0'";
		List<UserinfoHobby> list = new Vector<UserinfoHobby>();
		try {
			list = template.selete(sql, new USerInfoHobbyMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	} 

	public List<UserinfoHobby> findUserinfoAndHobby(String username) {
		String sql = "select  userinfo.username,password,sex,major,intro,hobby"
			   + " from userinfo left join hobby"
               + " on userinfo.username = hobby.username where userinfo.username= '";
        //?????????      
	    sql = sql + username +"' and userinfo.delFlg = '0' and hobby.delFlg = '0'";

		List<UserinfoHobby> list = new Vector<UserinfoHobby>();
		try {
			list = template.selete(sql, new USerInfoHobbyMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
    } 
	
	/**
	 * ????????????
	 * @param userinfo
	 * @return
	 */
	public boolean delUserinfo(String username) {
		int row = 0;
		String sql = "update userinfo set delFlg = '1' where username = ?";

		Object[] values = new Object[]{
				        username};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	public List<UserNameDto> findName(String username) {
		String sql = "select username from userinfo where delFlg = '0' and username= '";
        //?????????      
	    sql = sql + username +"'";

		List<UserNameDto> list = new Vector<UserNameDto>();
		try {
			list = template.selete(sql, new UserNameMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
    }


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	} 
	
}


	
	
	