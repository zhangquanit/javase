package terry.design.simplefactory;

import java.io.InputStream;
import java.util.Properties;


/**
  简单工厂
  创建客户端需要的对象
 */
public class UserLoginFactory {
	private static final String key="implclass";
	private UserLoginFactory(){}
	public enum LoginType{
		OA,SSL;
	}
	/**
	 * 由客户端传入参数来创建指定对象
	 *  缺点：客户端必须知道各参数的含义，一定程度上也暴露了内部实现
	 *      而且新增一个接口的实现类 就需要添加一个新的判断,需要改动源码
	 */
	public static LoginApi getUserAPI(LoginType type){
		LoginApi api=null;
		switch (type) {
		case OA:
			api=new OALoginImpl();
			break;

		case SSL:
			api=new SSLoginImpl();
			break;
			  
			//新增一个实现类  就需要添加一个判断
//		case XXX:
//			api=new XXXImpl();
//			
//			break;
		}
		return api;
	}
	/**
	 * 通过使用配置文件来获取用户需要创建的对象
	 * 优点：新增一个实现类不用改动源码
	 * @return
	 */
    public static LoginApi getUserApi(){
    	LoginApi api=null;
    	try{
    		//加载UserLoginFactory所在目录下的simplefactory.properties文件
        InputStream inputStream = UserLoginFactory.class.getResourceAsStream("simplefactory.properties");
          Properties properties = new Properties();
          properties.load(inputStream);
          String impleClassName = (String)properties.get(key);
            //通过反射创建对象
         Class<?> classObj = Class.forName(impleClassName);
          api= (LoginApi) classObj.newInstance();
    	}catch (Exception e) {
    		e.printStackTrace();
		}
       
        return api;
    }
	
}

