package terry.design.prototype;
/**
  
  张全
克隆的具体实现对象
 */
public class ConcretePrototype2 implements Prototype {
  private String name;
	@Override
	public Prototype cloneProduct() {
		return new ConcretePrototype2();//最简单的克隆,新建一个自身对象，由于没有属性,就不再赋值了
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}
