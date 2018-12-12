package terry.design.factory;
/**
  
  张全
 导出数据到txt文件中
 */
public class ExportFileApi_Txt implements ExportFileApi {

	@Override
	public boolean export(String data) {
	System.out.println("将数据"+data+"导出到.txt文件中");
		return true;
	}

}
