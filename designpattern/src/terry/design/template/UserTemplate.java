package terry.design.template;

/**
  
  张全
 模板类
 基于继承实现模板方法模式
 */
public abstract class UserTemplate {
  public abstract void create(UserModle user);
  public abstract void delete(String id);
  public abstract void update(String id);
  public abstract UserModle query(String id);
  
  //公共方法
  public void register(String id){
	  UserModle user = query(id);//先查询
	   if(null==user){
		   create(new UserModle());
	   }
  }
}
