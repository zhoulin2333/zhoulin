package co.jp.netwisdom.service;



import java.util.ArrayList;

import java.util.List;




import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import co.jp.netwisdom.dto.AjaxSearchUserDto;
import co.jp.netwisdom.dto.HobbyDto;

import co.jp.netwisdom.dto.UserinfoHobbyDto;
import co.jp.netwisdom.entity.UserinfoHobby;

import co.jp.netwisdom.mapper.UserinfoMapper;
import co.jp.netwisdom.utils.MyBatisUtil;


public class AjaxSearchUserService {
	public List<UserinfoHobbyDto> ajaxSearchUser(AjaxSearchUserDto dto){
		List<UserinfoHobby> list = new ArrayList<>();
    	//1得到 session工厂
    	SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    	//2得到session 
    	SqlSession sqlSession = sqlSessionFactory.openSession();
     	try{
	    	//3得到mapper
     		UserinfoMapper userinfoMapper = sqlSession.getMapper(UserinfoMapper.class);
	    	//4发出请求，执行数据库操作
     		list = userinfoMapper.findUserinfoAndHobby(dto.getUsername(), dto.getSex(), dto.getMajor());
	    	//需要提交
	    	sqlSession.commit();
    	}catch (Exception e) {
    		sqlSession.rollback();
    		System.out.print("抓到错误");
		}finally {
			sqlSession.close();
		}
		List<UserinfoHobbyDto> dtos = new ArrayList<UserinfoHobbyDto>();
		
		//标识dtos是否被创建
		List<String> userNames =  new ArrayList<String>();
		
		
		System.out.println("用户信息如下：");
		for(UserinfoHobby userinfoHobby: list ){

			//当用户名不存在时，证明大的dtos未创建
			if(!userNames.contains(userinfoHobby.getUsername())){
				UserinfoHobbyDto uhdto =new UserinfoHobbyDto(userinfoHobby.getUsername(),userinfoHobby.getPassword(),
						userinfoHobby.getSex(),userinfoHobby.getMajor(),
						userinfoHobby.getIntro());
				//将创建的大的dtos加到画面展示list里去
				dtos.add(uhdto);
				//将用户名加到userNames中
				userNames.add(userinfoHobby.getUsername());
				//将爱好加进子dto中
				if(userinfoHobby.getHobby() != null){
					uhdto.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
				}
				
			}else{
				for(UserinfoHobbyDto temp : dtos){
					//如果当前对象的名字等于传入进来的名字时
					if(temp.getUsername().equals(userinfoHobby.getUsername())){
						if(userinfoHobby.getHobby() != null){
							//将重复姓名的爱好加入子dto中
							temp.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
						}
					}
				}
			}
		 }
		return dtos;
	}
}