package cn.itcast.day2;

public @interface MetaAnnotation {
//只有一个属性时就可以不用@MetaAnnotaion(value=""),直接@MetaAnnotaion("xxx")
	String value();
}
