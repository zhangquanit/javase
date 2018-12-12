package terry.design.builder;
/**
  
  张全
  Txt文件构造生成器
 */
public class TxtBuilder implements Builder {
  private StringBuilder builder=new StringBuilder();
	@Override
	public void buildHead() {
		builder.append("构建txt文件头部信息\n");
	}

	@Override
	public void buildBody() {
		builder.append("构建txt文件体信息\n");
	}

	@Override
	public void buildTail() {
		builder.append("构建txt文件尾部信息\n");
	}

	/**
	 * 返回产品
	 * @return
	 */
	public  String getResult(){
		return this.builder.toString();
	}
}
