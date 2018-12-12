package terry.design.prototype;
/**
  
  张全
使用原型的客户端
 */
public class Client {
	private Prototype prototype;//持有需要使用的原型接口对象
	
	/**
	 * 构造方法  传入需要使用的原型接口对象
	 * @param prototype 需要使用的原型接口对象
	 */
	public Client(Prototype prototype){ //传入需要使用的原型接口对象
		this.prototype=prototype;
	}
	/**
	 * 示意方法，执行某个功能操作
	 */
  public void operation(){
	  //需要创建原型接口的对象
	  Prototype newOject=prototype.cloneProduct();//克隆出来的对象与原对象没有任何关系,修改它的值也不会影响原对象。
  }
}
