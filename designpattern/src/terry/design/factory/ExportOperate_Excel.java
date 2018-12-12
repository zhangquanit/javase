package terry.design.factory;
/**
  
  张全
  返回导出Excel实例
 */
public class ExportOperate_Excel extends ExportOperate {

	@Override
	ExportFileApi getApi() {
		return new ExportFileApi_Excel();
	}

}
