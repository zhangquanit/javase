import java.net.Proxy;
import java.util.DuplicateFormatFlagsException;

import org.junit.Test;

import terry.design.abstractfactory.AbstractFactory;
import terry.design.abstractfactory.Engineer;
import terry.design.abstractfactory.FactoryImpl_Amd;
import terry.design.abstractfactory.FactoryImpl_Intel;
import terry.design.adapter.Adaptee;
import terry.design.adapter.AdapteeImpl;
import terry.design.adapter.Adapter;
import terry.design.adapter.ClassAdapter;
import terry.design.adapter.Target;
import terry.design.adapter.TargetImpl;
import terry.design.adapter.TwoDirectionAdapter;
import terry.design.builder.Builder;
import terry.design.builder.Director;
import terry.design.builder.TxtBuilder;
import terry.design.facade.FImplA;
import terry.design.facade.FImplB;
import terry.design.facade.FInterfaceA;
import terry.design.facade.FInterfaceB;
import terry.design.facade.Facade;
import terry.design.factory.ExportOperate;
import terry.design.factory.ExportOperate_Excel;
import terry.design.factory.ExportOperate_Txt;
import terry.design.observer.ConcreteMyObserverable;
import terry.design.observer.ConcreteObserver;
import terry.design.observer.ConcreteObserver2;
import terry.design.observer.ConcreteObserver3;
import terry.design.observer.MyObserver;
import terry.design.prototype.Client;
import terry.design.prototype.ConcretePrototype;
import terry.design.proxy.ProxyUser;
import terry.design.proxy.UserApi;
import terry.design.proxy.UserImpl;
import terry.design.simplefactory.LoginApi;
import terry.design.simplefactory.OALoginImpl;
import terry.design.simplefactory.UserLoginFactory;
import terry.design.strategy.LogContext;
import terry.design.template.CommanUser;
import terry.design.template.UserCallBack;
import terry.design.template.UserCallBackTemplate;
import terry.design.template.UserModle;
import terry.design.template.UserTemplate;

/**
 * 张全
 */
public class MainTest {

	/*
	 * 1.简单工厂 创建需要的对象 隔离外部调用和具体实现 面向接口编程
	 */
	@Test
	public void test1() {
		// 1.不使用简单工厂,需要知道接口具体的实现即接口的具体实现类是什么，而且暴露了内部实现，一旦实现类改变还的
		// 改变客户端调用
		LoginApi api = new OALoginImpl();
		api.login("terry", "112");

		// 2.客户端只关心得到需要的接口对象,然后就调用接口对象的功能,而不用关心具体的实现
		// LoginApi oa = UserLoginFactory.getUserAPI(LoginType.OA);//客户端传入参数
		LoginApi oa = UserLoginFactory.getUserApi();// 通过配置文件
		oa.login("terry", "112");
	}

	/*
	 * 2.外观模式
	 */
	@Test
	public void test2() {
		// 1.不使用外观模式 客户端需要知道每个模块具体的实现，这样客户端和每个模块都有依赖关系
		FInterfaceA apiA = new FImplA();
		FInterfaceB apiB = new FImplB();
		apiA.testA();
		apiB.testB();

		// 2.使用外观模式 使得外部调用和各模块之间松耦合,外部调用只和外观类交互，而且简化了调用
		Facade.getInstance().test();
	}

	/**
	 * 适配器模式 转换匹配,复用功能
	 */
	@Test
	public void test3() {
		Adaptee adaptee = new AdapteeImpl();// 已有功能
		// 1.将已有功能接口适配成客户端调用接口
		Target target = new Adapter(adaptee);
		target.newApi();

		// 2.双向适配器
		target = new TargetImpl();
		// 1).将已有功能接口适配成新版接口
		Target targetApi = new TwoDirectionAdapter(adaptee, target);// 新版接口使用老版已有功能
		targetApi.newApi();
		// 2).將新接口适配成旧接口
		Adaptee adapteeApi = new TwoDirectionAdapter(adaptee, target);// 老版接口也可以使用新版接口功能
		adapteeApi.old();
		// 3.类适配器
		ClassAdapter adapter1 = new ClassAdapter();
		adapter1.old();
		adapter1.newApi();

	}

	/**
	 * 工厂方法模式
	 */
	@Test
	public void test4() {
		ExportOperate operate = new ExportOperate_Excel();
		operate.export("测试数据");// 功能是在父类中完成的，注意和一般多态调用的区别,
		operate = new ExportOperate_Txt();
		operate.export("测试数据");

	}

	/**
	 * 抽象工厂模式
	 */
	@Test
	public void test5() {
		AbstractFactory factory = new FactoryImpl_Intel();// 用户选用Intel方案
		Engineer engineer = new Engineer();
		engineer.makeComputer(factory);

		factory = new FactoryImpl_Amd();// 用户选用Amd方案
		engineer.makeComputer(factory);

	}

	/**
	 * 生成器模式
	 */
	@Test
	public void test6() {
		TxtBuilder builder = new TxtBuilder();// 具体的生成器 负责部件构造
		Director director = new Director(builder);// 指导者 负责整体构建算法
		director.construct();// 构造

		String result = builder.getResult();// 返回构建完成的对象
		System.out.println("result=" + result);
	}

	/**
	 * 原型模式
	 */
	@Test
	public void test7() {
		ConcretePrototype prototype = new ConcretePrototype();
		prototype.setName("one");
		Client client = new Client(prototype);
		client.operation();

	}

	/**
	 * 中介者模式
	 */
	@Test
	public void test8() {
		terry.design.mediator.Client client = new terry.design.mediator.Client();
		client.login();

	}

	/**
	 * 代理模式
	 */
	@Test
	public void test9() {
		UserApi userApi = new UserImpl();
		ProxyUser proxyUser = new ProxyUser(userApi);// 使用代理类代理UserImpl的功能
		proxyUser.setUserName("zhangquan");

	}

	/**
	 * 观察者模式
	 */
	@Test
	public void test10() {
		//观察者
		MyObserver observer1 = new ConcreteObserver();
		observer1.setLevel(1);
		MyObserver observer2 = new ConcreteObserver2();
		observer2.setLevel(2);
		MyObserver observer3 = new ConcreteObserver3();
		observer3.setLevel(3);

		//被观察者
		ConcreteMyObserverable observerable = new ConcreteMyObserverable();
		//注册观察者
		observerable.addObserver(observer1);
		observerable.addObserver(observer2);
		observerable.addObserver(observer3);
		
		observerable.setChanged(true);//设置当状态变化时通知观察者
//		observerable.changeContent("等级<=1观察者得到通知");
		observerable.changeContent("等级<=2观察者得到通知");
//		observerable.changeContent("等级<=3观察者得到通知");

	}
	
	/**
	 * 命令模式
	 */
	@Test
	public void test11(){
		terry.design.command.Client client=new terry.design.command.Client();
		client.dish();//执行命令
	}
	
	/**
	 * 策略模式
	 * 
	 */
	@Test
	public void test12(){
		LogContext ctx=new LogContext();
		ctx.log("数据库日志");
		ctx.log("文件日志信息");
	}
	
	/**
	 * 模板方法模式
	 */
	@Test
	public void test13(){
		String userId="1";
		//1.继承的实现
		UserTemplate template=new CommanUser();
		template.register(userId);
		//2.回调的实现
		UserCallBackTemplate callBackTemplate=new UserCallBackTemplate();
		callBackTemplate.register(userId, new UserCallBack() {
			
			@Override
			public void update(String id) {
				
			}
			
			@Override
			public UserModle query(String id) {
				System.out.println("...........query");
				return null;
			}
			
			@Override
			public void delete(String id) {
				
			}
			
			@Override
			public void create(UserModle user) {
				System.out.println("...........create");
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
