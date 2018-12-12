package terry.design.strategy;

/**
 * 张全 日志记录上下文
 */
public class LogContext {
	public void log(String msg) {
       //优先选用策略，记录到数据库中
		LogStrategy strategy=new DbLog();
		try{
			strategy.log(msg);
		}catch (Exception e) {
			strategy=new FileLog();//出错了，那就记录到文件中
			strategy.log(msg);
		}
	}
}
