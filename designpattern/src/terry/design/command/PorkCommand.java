package terry.design.command;
/**
  
  张全

  具体命令接口实现类
 */
public class PorkCommand implements Command {
   public  CookApi cookApi;//持有命令对象
    public  void setCookApi(CookApi cookApi){
    	this.cookApi=cookApi;
    }
	@Override
	public void execute() {
      this.cookApi.cook("凉拌猪肉");
	}

}
