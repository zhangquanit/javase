package terry.design.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
  
  张全

被观察者
 */
public  abstract class MyObserverable {
   private boolean changed=false;//设置变化时是否通知观察者
   public List<MyObserver> observerableList=new ArrayList<MyObserver>();//持有一个观察者集合
    public void addObserver(MyObserver observer){
    	  observerableList.add(observer);
    }
    public void removeObserver(Observer observer){
    	observerableList.remove(observer);
    }
    public  void setChanged(boolean changed){
    	this.changed=changed;
    }
    public boolean getChanged(){
    	return this.changed;
    }
    //一般通知方法都是直接通知所有的观察者  这里是根据条件通知不同的观察者
    public abstract void notifyObserver(Object content);
    
}
