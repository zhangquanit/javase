package com.cn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 *            自定义注解
 * RetentionPolicy枚举的三个值 SOURCE,CLASS,RUNTIME
 * 注释保留策略。此枚举类型的常量描述保留注释的不同策略。它们与 Retention 元注释类型一起使用，以指定保留多
 * 长的注释。 
CLASS 
          编译器将把注释记录在类文件中，但在运行时 VM 不需要保留注释。 
RUNTIME 
          编译器将把注释记录在类文件中，在运行时 VM 将保留注释，因此可以反射性地读取。 
SOURCE 
          编译器要丢弃的注释。 
@target指定注解的的作用范围

 注解的属性：8种基本类型及其对应的数组，String，Class，枚举、注解
 */
@Target({ElementType.TYPE}) //定义该注解的作用范围
@Retention(RetentionPolicy.RUNTIME) //指定该注解的保留策略
public @interface Thinkmore {
  public String name()default "terry"; //默认属性    调用注解时可以不用添加值
  public int age(); //普通属性  调用注解时必须设值 
  public String[] lobbys(); //数组
  InnerAnn annotationAttr()default @InnerAnn(username = "jack"); //属性值为注解  并设置默认值

}

 @interface InnerAnn{
	public String username();
}
 class InnerClass{
	 
 }
