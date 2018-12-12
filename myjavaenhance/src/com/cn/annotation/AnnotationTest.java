package com.cn.annotation;

/**
 * 使用自定义的注解
 * @author Administrator
 *
 */
@Thinkmore(age=26, lobbys={"篮球","街舞"},annotationAttr=@InnerAnn(username="jack"))
public class AnnotationTest {
	
  public static void main(String[] args) {
	Class classObj=AnnotationTest.class;
	if(classObj.isAnnotationPresent(Thinkmore.class)){//判断该类使用使用了注解Thinkmore
		Thinkmore thinkmore=(Thinkmore)classObj.getAnnotation(Thinkmore.class);//取得该注解
		System.out.println(thinkmore);
		System.out.println("name="+thinkmore.name()+",age="+thinkmore.age());//打印注释的属性
		System.out.println("lobbys:"+thinkmore.lobbys().length);
		System.out.println("注解中的属性也是注解:"+thinkmore.annotationAttr().username());
		
	}
}
}
