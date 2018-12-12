package com.cn.proxy;

class Person{
	public void say(){}
}
//代理一：除了简单的代理Person类的说话功能，还可以唱歌
public class OneProxy {
	private Person person;
	public OneProxy(Person person){
		this.person=person;
	}
  public void say(){//创建与目标类同样的方法
	  this.person.say();//调用目标类的方法
	  this.sing();//添加辅助功能，除了目标类的方法，它还可以调用自己的方法
  }
  public void sing(){
	  System.out.println("除了简单的说话，我会在说话的时候唱歌");
  }
}
//代理二：除了简单的代理Person类的说话功能，还可以跳舞
class TwoProxy{
	private Person person;
	public TwoProxy(Person person){
		this.person=person;
	}
  public void say(){//创建与目标类同样的方法
	  this.person.say();//调用目标类的方法
	  this.dance();//添加辅助功能，除了目标类的方法，它还可以调用自己的方法
  }
  public void dance(){
	  System.out.println("除了简单的说话，我会在说话的时候跳舞");
  }
}

