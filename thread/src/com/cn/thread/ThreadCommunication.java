package com.cn.thread;
/** 
 * 
       生产和消费同步：生产后才给消费者消费,
 */
public class ThreadCommunication {
	public static void main(String[] args)throws Exception {
		   Person person=new Person();
		   Producer producer=new Producer(person);
		   Consumer consumer=new Consumer(person);
		   
	     new Thread(producer).start();
	     new Thread(consumer).start();
	     
	     
	     Thread.currentThread().sleep(500);
	     producer.stop();
	     consumer.stop();
	     
	     
	}
     
}

class Producer implements Runnable{
   
   Person per;
   boolean flag=true;
   public Producer(Person per){
	   this.per=per;
   }
	@Override
	public void run() {
		int i=0;
	   while(flag){
          
            	if(i==0){
            per.put("张三","male");
    		    }else{
    		per.put("李四", "female");
    		    } 

    		    i=(i+1)%2; //在0和1之间循环
			}
		    
	   
	}
	public void stop(){
		flag=false;
	}
}
class Consumer implements Runnable{
	Person per;
	boolean flag = true;

	public Consumer(Person per) {
		this.per = per;
	}

	@Override
	public void run() {

		while (flag) {
			per.get();

		}
	}

	public void stop() {
		flag = false;   
	}
}
class Person{
	String name;
	String sex;
	boolean bFull = false;

	public Person() {
	}

	public synchronized void put(String name, String sex) {
		if (bFull) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		bFull = true;
		notify(); // 设值后通知等待的线程,要求是同一个监视对象,这里是当前对象

	}

	public synchronized void get() {

		if (!bFull) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

		System.out.println("姓名:" + this.name + ",性别：" + this.sex);
		bFull = false;
		notify();
	}
}

