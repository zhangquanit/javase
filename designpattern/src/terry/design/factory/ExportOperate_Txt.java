package terry.design.factory;
/**
  
  张全
  返回导出Txt实例
 */
public class ExportOperate_Txt extends ExportOperate {

	@Override
	ExportFileApi getApi() {
		return new ExportFileApi_Txt();
	}

}
