package terry.design.factory;
/**
  
  张全
导出文件业务类
 */
public abstract class ExportOperate {
  
   abstract ExportFileApi getApi();//由子类去决定实例化哪一个API
   
   /**
    * 在不知道具体实现的情况下  完成自身功能调用
    */
   public void export(String data){
	   ExportFileApi api = getApi();
	   api.export(data);
   }
}
