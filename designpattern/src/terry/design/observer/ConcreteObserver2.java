package terry.design.observer;

/**
 * 张全
 */
public class ConcreteObserver2 implements MyObserver {
	private int level;
	@Override
	public void update(MyObserverable observerable, Object content) {
        System.out.println(content);
	}
	@Override
	public void setLevel(int level) {
      this.level=level;		
	}

	@Override
	public int getLevel() {
		return this.level;
	}

}
