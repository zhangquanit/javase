package terry.design.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
  
  张全

实现日志策略的抽象模板，因为所有的记录日志都要求在日志前添加记录时间
 */
public abstract class LogStrategyTemplate implements LogStrategy {

	@Override
	public void log(String msg) {
      //第一步，为日志消息添加记录时间
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd HHmmss");
		msg=format.format(new Date())+msg;
		doLog(msg);//真正执行日志记录，让子类去具体实现
	}

	public abstract void doLog(String msg);
}
