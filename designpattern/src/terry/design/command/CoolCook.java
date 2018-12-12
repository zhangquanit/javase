package terry.design.command;
/**
  
  张全
Receiver：接收者   具体实现业务功能
 */
public class CoolCook implements CookApi {

	@Override
	public void cook(String name) {
     System.out.println("做凉菜->"+name);
	}

}
