package co.jp.netwisdom.utils;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.jp.netwisdom.dao.UserinfoDAO;


public class Test2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserinfoDAO dao = (UserinfoDAO)ctx.getBean("userinfoDAO");
	    System.out.println(dao.getClass());
	    System.out.println(dao.getUsername());
	    System.out.println(dao.getTemplate().getClass());
	}
}
