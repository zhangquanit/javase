package terry.design.template;

/**
 * 张全
 * 回调接口
 */
public interface UserCallBack {
	void create(UserModle user);

	void delete(String id);

	void update(String id);

	UserModle query(String id);
}
