package terry.design.observer;
/**
  
  张全

观察者接口
 */
public interface  MyObserver {
	public void setLevel(int level);
	public int getLevel();
 public void update(MyObserverable observerable,Object content);
}
