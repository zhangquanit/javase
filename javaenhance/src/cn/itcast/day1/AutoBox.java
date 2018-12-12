package cn.itcast.day1;

public class AutoBox {

	/** 自动装箱和拆箱
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer iObj = 3; //自动装箱  int..........>Integer
		System.out.println(iObj + 12);//自动拆箱    Integer...>int
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1==s2);
		Integer i1 = 137;
		Integer i2 = 137;
		

		System.out.println(i1 == i2);//false
		
		Integer i3 = Integer.valueOf(213);
		Integer i4 = Integer.valueOf(213);
		System.out.println(i3==i4);
		
	}

}
