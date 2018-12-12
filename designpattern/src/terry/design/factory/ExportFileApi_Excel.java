package terry.design.factory;
/**
  
  张全
 导出数据到Excel文件中
 */
public class ExportFileApi_Excel implements ExportFileApi {

	@Override
	public boolean export(String data) {
	System.out.println("将数据"+data+"导出到excel文件中");
		return true;
	}

}
