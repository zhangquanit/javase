package terry.design.template;
/**
  
  张全
会员用户
 */
public class MemberUser extends UserTemplate{

	@Override
	public void create(UserModle user) {
		System.out.println("创建会员用户");
	}

	@Override
	public void delete(String id) {
		System.out.println("删除会员用户");
	}

	@Override
	public void update(String id) {
		System.out.println("更新会员用户");
	}

	@Override
	public UserModle query(String id) {
		System.out.println("查询会员用户");
		return null;
	}

}
