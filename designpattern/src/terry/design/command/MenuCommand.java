package terry.design.command;

import java.util.ArrayList;
import java.util.List;


/**
  
  张全
  宏命令：
 */
public class MenuCommand implements Command {
	private List<Command> cmdList=new ArrayList<>();//持有命令集合
	public void addCommand(Command cmd){
		this.cmdList.add(cmd);
	}

	@Override
	public void execute() {
       for(Command cmd:cmdList){
    	   cmd.execute();//循环执行命令
       }
	}

}
