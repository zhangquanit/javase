package terry.design.adapter;
/**
  
  张全
类适配器
  继承已有功能实现类,实现新接口,这样即继承了已有功能,同时外部调用Target接口功能又可转调已有功能
 */
public class ClassAdapter extends AdapteeImpl implements Target {

	@Override
	public void newApi() {
        old();//转调已有功能
	}

}
