package busybox;

import java.io.File;

public class Dir {
	
	public static void mkdir(String path){
	    File dir=new File(path);
	    if(dir.exists()) {
	    	System.out.println("File exists");
	    }else {
	    	dir.mkdir();
	    	if (dir.isDirectory()) System.out.println("创建成功");
	    	else System.out.println("创建失败");
	    }
	}
	
	private static boolean isEmp(String path) {
		File file = new File(path);
		File[] listFiles = file.listFiles();
		if(listFiles.length == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static void rmdir(String path){
	    File dir=new File(path);
	    if(dir.exists()) {
	    	if(isEmp(path)) {
	    		dir.delete();
				System.out.println("删除成功");
	    	}else {
	    		System.out.println("文件夹不为空");
	    	}
	    }else {
	    	System.out.println("未找到该文件夹");
	    }
	        
	}

}
