package cn.itcast.day2;

import java.util.Date;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		System.out.println(ClassLoaderTest.class.getClassLoader().getClass()
				.getName());
		System.out.println(System.class.getClassLoader());
		
		System.out.println("..........start");
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
		System.out.println(loader);

		System.out.println("...........end");
		
		Class clazz = new MyClassLoader("itcastlib")
				.loadClass("cn.itcast.day2.ClassLoaderAttachment");
		Date d1 = (Date) clazz.newInstance();
		System.out.println(d1);
	}

}
