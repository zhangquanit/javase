package cn.itcast.day1;

/**
 * 用普通类模拟枚举的功能
 * @author Administrator
 *
 */
public abstract class WeekDay1 {
	//私有的构造方法  防止用户自己创建对象   只能用类中定义好的对象
	private WeekDay1(){}
	
	public final static WeekDay1 SUN = new WeekDay1(){

		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return MON;
		}
		
	};
	//匿名内部类
	public final static WeekDay1 MON = new WeekDay1(){

		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return SUN;
		}
		
	};	
	
	public abstract WeekDay1 nextDay();
	
/*	public WeekDay nextDay(){
		if(this == SUN){
			return  MON;
		}else{
			return SUN;
		}
	}
*/
	
	public String toString(){
		return this==SUN?"SUN":"MON";
	}
}
