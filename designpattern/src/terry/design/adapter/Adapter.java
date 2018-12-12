package terry.design.adapter;
/**
  
  张全
适配器
 */
public class Adapter implements Target{
 private Adaptee adaptee;//持有旧接口对象
  public Adapter(Adaptee adaptee){
	  this.adaptee=adaptee;
  }
	@Override
	public void newApi() {
		//可以实现一些其他功能
		
		if(null!=adaptee){
			adaptee.old();//转调已有的实现
		}
	}
  
}
