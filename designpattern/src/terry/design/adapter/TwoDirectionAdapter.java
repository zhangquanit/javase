package terry.design.adapter;
/**
  
  张全
  双向适配器
 */
public class TwoDirectionAdapter implements Adaptee, Target {
	private Adaptee adaptee;//旧接口对象
	private Target target;//新接口对象
	public TwoDirectionAdapter(Adaptee adaptee,Target target){
		this.adaptee=adaptee;
		this.target=target;
	}

	@Override
	public void newApi() {
      this.adaptee.old();//转调已有功能实现
	}

	@Override
	public void old() {
     this.target.newApi();//转调新接口实现
	}

}
