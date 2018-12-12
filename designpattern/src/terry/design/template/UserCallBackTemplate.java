package terry.design.template;
/**
  
  张全
基于回调实现模板方法模式
 */
public class UserCallBackTemplate {
	
	  public void register(String id,UserCallBack callBack){
		  UserModle user= callBack.query(id);
		   if(null==user){
			   callBack.create(new UserModle());
		   }
	  }
}
