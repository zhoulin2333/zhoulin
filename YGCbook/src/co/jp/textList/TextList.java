package co.jp.textList;

import java.util.ArrayList;
import java.util.List;

public class TextList {
    
	public static void main(String[]args){
		List<String> list = new ArrayList<String>();
		
		//装张三李四王五
		list.add("张三");
		list.add("李四");
		list.add("王五");
        //普通for循环打印每一个对象
		for(int i=0;i<list.size();i++){
			//数组中得到每一个对象用get方法
			System.out.println(list.get(i));
			
		}
		//for each 循环中
		//for(集合中每一个数值类型-泛型    每一个对象名（形式参数） ： 要遍历的集合对象){
		
	
	    //for each不能精确的拿到数组里的某一位，但for循环可以
		for(String name : list){
			System.out.println(name);
		}
	    //List<Intager> list1 = new ArrayList<Intager>();
		List<Integer> list1 = new ArrayList<Integer>();
	
	
	}
	
}
