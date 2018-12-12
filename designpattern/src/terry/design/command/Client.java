package terry.design.command;
/**
  
  张全

 */
public class Client {

	 public void dish(){
		    //创建服务员  Invoker
		    Invoker waiter=new Invoker();
		    //创建命令对象
		    Command duck=new DuckCommand();
		    Command pork=new PorkCommand();
		    //点菜 就是把这些菜(命令)让服务员记录下来
		    waiter.orderDish(duck);
		    waiter.orderDish(pork);
		    //点菜完毕
		    waiter.dishOver();
		
	 }
}
