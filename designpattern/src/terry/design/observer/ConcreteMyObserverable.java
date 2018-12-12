package terry.design.observer;
/**
  
  张全
 具体的目标对象/被观察者对象
 */
public class ConcreteMyObserverable extends MyObserverable {
    private String content;
	public void changeContent(String content){
		this.content=content;
		notifyObserver(content);
	}
	public String getContent(){
		return this.content;
	}
	@Override
	public void notifyObserver(Object content) {
		boolean changed = getChanged();//客户端是否设置过需要得到通知
		 if(changed){
         for(MyObserver observer:observerableList){ //根据条件来选择通知观察者	
        	   int observerLevel=observer.getLevel();
        	 if("等级<=1观察者得到通知".equals(content)&&observerLevel<=1){
        		 observer.update(this, content);
        	 }
        	 if("等级<=2观察者得到通知".equals(content)&&observerLevel<=2){
        		 observer.update(this, content);
        	 }
        	 if("等级<=3观察者得到通知".equals(content)&&observerLevel<=3){
        		 observer.update(this, content);
        	 }
         }
		 }
	}
}
