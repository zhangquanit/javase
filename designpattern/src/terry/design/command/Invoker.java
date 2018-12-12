package terry.design.command;
/**
  
  张全
组装命令对象和接收者
 */
public class Invoker {
 private MenuCommand menuCommand=new MenuCommand();
 
 //点菜
  public void orderDish(Command cmd){
	   //创建接收者
	   CookApi hotCook=new HotCook();
	   CookApi coolCook=new CoolCook();
	   //创建命令对象 并给命令对象设置接收者
	   if(cmd instanceof DuckCommand){
		   ((DuckCommand) cmd).setCookApi(hotCook);
	   }else if(cmd instanceof PorkCommand){
		   ((PorkCommand) cmd).setCookApi(coolCook);
	   }
	   menuCommand.addCommand(cmd);//将命令添加到宏命令集合中
		   
  }
  //点菜完毕
  public void dishOver(){
	  menuCommand.execute();//执行宏命令
  }
}
