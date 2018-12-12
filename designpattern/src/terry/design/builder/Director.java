package terry.design.builder;
/**
  
  张全
  指导者：负责构建算法
 */
public class Director {
	private Builder builder;//维护一个生成器接口对象
	public Director(Builder builder){
		this.builder=builder;
	}
	/**
	 * 封装构建对象过程
	 */
  public void  construct(){
	  builder.buildHead();
	  builder.buildBody();
	  builder.buildTail();
  }
}
