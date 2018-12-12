import java.util.ArrayList;
import java.util.List;

/**
 * @author 张全
 */
public class CloneTest {
	// 实现Cloneable接口
	public class Car implements Cloneable {
		public String carType;// 车型
		public float price; // 车价

		@Override
		protected Car clone() throws CloneNotSupportedException {
			return (Car) super.clone();
		}
	}

	public class Person implements Cloneable {
		public String name;
		public int age;
		public Car car;

		//自己实现深度克隆
		public Person clonePerson() {
			// new一个新实例，并将属性赋值到新对象中
			Person newPerson = new Person();
			newPerson.name = this.name;
			newPerson.age = this.age;
			newPerson.car = this.car;

			return newPerson;
		}

		@Override
		protected Person clone() throws CloneNotSupportedException {
			Person newPerson=(Person) super.clone();
			newPerson.car=this.car.clone();//克隆car属性
			return newPerson;
		}
	}

	public void test() {
		Car car = new Car();
		car.carType = "奔驰";
		car.price = 1000000;

		Person person = new Person();
		person.name = "张三";
		person.age = 30;
		person.car = car;

		Person clonePerson = person.clonePerson();
		// 深度克隆，clonePerson.car与person.car不相同
		boolean equal = clonePerson.car == person.car; //false

		// 改变原始对象中的car中的属性值，不会改变克隆对象中的car属性值
		person.car.carType = "宝马";
		String carType = clonePerson.car.carType; // 还是之前"奔驰"

	}

	public static void main(String[] args) {
		new CloneTest().test();
		
		List<String> list=new ArrayList<String>();
		list.add("one");
		list.add("two");
		
		//将list中的值赋值到newList中
		List<String> newList = new ArrayList<>(list);
		newList.add("three");
		

	}

}
