package com.cn.thread;
/** 
 * 
 * @author terry
 * @time 2012-5-9 下午9:44:34
 */
public class MainTest {
  public static void main(String[] args) throws Exception{
	NPerson peron=new NPerson();
	NProducer producer=new NProducer(peron);
	NConsumer consumer=new NConsumer(peron);
	new Thread(producer).start();
	new Thread(consumer).start();
	
	Thread.currentThread().sleep(500);
	
}
}

class NProducer implements Runnable{
    NPerson person;
    boolean flag=true;
    public NProducer(NPerson person){
    	this.person=person;
    }
	@Override
	public void run() {
		int i=0;
		while(flag){
//			synchronized (person) {
//				
//			}
		   if(i==0){
			  person.name="张全";
			  person.sex="男";
		   }else{
			   person.name="小兔兔";
				person.sex="女";
		   }
		   i=(i+1)%2;
		}
		
	}
	public void stop(){
		flag=false;
	}
}
class NConsumer implements Runnable{
	 NPerson person;
	 boolean flag=true;
	    public NConsumer(NPerson person){
	    	this.person=person;
	    }
	@Override
	public void run() {
		while(flag){
//			synchronized (person) {
//				
//			}
			System.out.println("姓名:"+person.getName()+",性别:"+person.getSex());
		}
		
	}
   
	public void stop(){
		flag=false;
	}
}
class NPerson{
	String name;
	String sex;
	public String getName(){
		return this.name;
	}
	public String getSex(){
		return this.sex;
	}
	
}
