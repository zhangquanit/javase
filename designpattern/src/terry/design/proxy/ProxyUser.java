package terry.design.proxy;
/**
  
  张全
  代理对象，代理目标对象的功能
 */
public class ProxyUser implements UserApi {
    public UserApi userApi=null;//持有被代理的具体的目标对象
    public ProxyUser(UserApi userApi){
    	this.userApi=userApi;
    }
	@Override
	public void setUserName(String username) {
		 //在转调具体的目标对象前，可以执行一些功能处理
      if(!username.equals("zhangquan")){
    	  userApi.setUserName(username);//面向接口编程,无需知道具体的实现
      }else{
    	  System.out.println("username不能为："+username);
      }
      //在转调具体的目标对象后，可以执行一些功能处理
	}

	@Override
	public void setAge() {

	}

}
