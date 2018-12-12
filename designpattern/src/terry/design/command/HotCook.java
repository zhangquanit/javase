package terry.design.command;
/**
  
  张全

Receiver  接收者
 */
public class HotCook implements CookApi {

	@Override
	public void cook(String name) {
     System.out.println("做热菜->"+name);
	}

}
