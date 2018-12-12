package cn.itcast.day1;


public class VarableParameter {

	/**可变参数 
	 * @note  可变参数可用数组接收
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		System.out.println(add(2,3));
		System.out.println(add(2,3,5));		
		System.out.println(add(new int[]{1,2,3}));
	}
	public static int add(int... args){
		int sum = 0;
		for(int i=0;i<args.length;i++){
			sum += args[i];
		}
		for(int arg : args){
			sum += arg;
		}
		return sum;
	}

}
