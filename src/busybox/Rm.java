package busybox;

import java.io.File;

public class Rm {
	public static void rm(String path){
	     File dir=new File(path);
	     if(dir.exists()){
	         File[] tmp=dir.listFiles();
	         for(int i=0;i<tmp.length;i++){
	             if(tmp[i].isDirectory()){
	                 rm(path+"/"+tmp[i].getName());
	             }
	             else{
	                 tmp[i].delete();
	             }
	         }
	         dir.delete();
	         if (tmp.length == 0){
				 System.out.println("ɾ���ɹ�");
			 }
	     }else {
	        	System.out.println("δ�ҵ����ļ�");
	     }
	 }

}
