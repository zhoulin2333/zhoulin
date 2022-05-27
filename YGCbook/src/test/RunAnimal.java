package test;

import java.util.ArrayList;
import java.util.List;

public class RunAnimal {
	 public static void main(String[] args) {
		
		 
		 Animal hz = new Animal("猴子","母",6);
		 Animal dx = new Animal("大象","公",8);
		 Animal sz = new Animal("狮子","母",9);
//		 Animal[] animal = new Animal[]{animal1,animal2,animal3};
//		 
//		 List<Animal> animals = new ArrayList<Animal>();
//		 for(int i=0;i<animal.length;i++){
//			   animals.add(animal[i]);
//			   System.out.println(animals.get(i).getName()+"'"+
//					              animals.get(i).getGender()+"'"+
//					              animals.get(i).getAge());
//		 }
//		 
//		 
		 List<Animal> animalList = new ArrayList<Animal>();
		 animalList.add(hz);
		 animalList.add(dx);
		 animalList.add(sz);
		 
		 for(int i=0;i<animalList.size();i++){;
		       Animal animals = animalList.get(i);
			   System.out.println(animals.getName()+","+
				            animals.getAge()+","+
				            animals.getGender());
		 }
		 
		 
		 for(Animal animals:animalList){
			 System.out.println(animals.getName()+","+
					            animals.getAge()+","+
					            animals.getGender());
		 }
	}

}
