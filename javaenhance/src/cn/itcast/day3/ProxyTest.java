package cn.itcast.day3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 动态代理：代理对象需要实现和目标对象相同的接口
 *
 */
public class ProxyTest {
	public static void main(String[] args) throws Exception{
		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(clazzProxy1.getName());
		
		System.out.println("----------begin constructors list----------");
		/*$Proxy0()
		$Proxy0(InvocationHandler,int)*/
		Constructor[] constructors = clazzProxy1.getConstructors();
		for(Constructor constructor : constructors){
			String name = constructor.getName();
			StringBuilder sBuilder = new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParams = constructor.getParameterTypes();
			for(Class clazzParam : clazzParams){
				sBuilder.append(clazzParam.getName()).append(',');
			}
			if(clazzParams!=null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder.toString());			
		}

		System.out.println("----------begin methods list----------");
		/*$Proxy0()
		$Proxy0(InvocationHandler,int)*/
		Method[] methods = clazzProxy1.getMethods();
		for(Method method : methods){
			String name = method.getName();
			StringBuilder sBuilder = new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParams = method.getParameterTypes();
			for(Class clazzParam : clazzParams){
				sBuilder.append(clazzParam.getName()).append(',');
			}
			if(clazzParams!=null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder.toString());			
		}
		
		                        //创建动态代理类的实例对象
		System.out.println("----------begin create instance object----------");
		
		//Object obj = clazzProxy1.newInstance();
		Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
		class MyInvocationHander1 implements InvocationHandler{

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		
		}
		Collection proxy1 = (Collection)constructor.newInstance(new MyInvocationHander1());
		
		System.out.println(proxy1);
		proxy1.clear();
		//proxy1.size();//InvocationHandler的invoke返回null  null无法转成int
		
		//得到的代理对象必须是目标对象实现的接口
		final ArrayList target = new ArrayList();			
		Collection proxy3 = (Collection)getProxy(target,new MyAdvice());//不能强转为ArrayList
		proxy3.add("zxx");
		proxy3.add("lhm");
		proxy3.add("bxd");
		System.out.println(proxy3.size());
		System.out.println(proxy3.getClass().getName());
	}

	private static Object getProxy(final Object target,final Advice advice) {
		Object proxy3 = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				/*new Class[]{Collection.class},*/
				target.getClass().getInterfaces(),
				new InvocationHandler(){
				
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						advice.beforeMethod(method);
						Object retVal = method.invoke(target, args);
						advice.afterMethod(method);
						return retVal;						
						
					}
				}
				);
		return proxy3;
	}

}
