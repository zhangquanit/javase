package terry.design.template;
/**
  
  张全
普通用户
 */
public class CommanUser extends UserTemplate {

	@Override
	public void create(UserModle user) {
		System.out.println("创建普通用户");
	}

	@Override
	public void delete(String id) {
		System.out.println("删除普通用户");
	}

	@Override
	public void update(String id) {
		System.out.println("更新普通用户");
	}

	@Override
	public UserModle query(String id) {
		System.out.println("查询普通用户");
		return null;
	}

}
