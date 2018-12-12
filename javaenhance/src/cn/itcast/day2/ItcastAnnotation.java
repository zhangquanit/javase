package cn.itcast.day2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.itcast.day1.EnumTest;

@Retention(RetentionPolicy.RUNTIME)//元注解：给注解类添加的注解
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ItcastAnnotation {
	//注解属性 ：基本数据类型及它们的数组、String及String数组、枚举、注解、Class、
	String color() default "blue";
	String value();
	int[] arrayAttr() default {3,4,4};
	Class<?> getCls() default String.class;
	EnumTest.TrafficLamp lamp() default EnumTest.TrafficLamp.RED;
	MetaAnnotation annotationAttr() default @MetaAnnotation("lhm");
}
