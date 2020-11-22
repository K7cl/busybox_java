package busybox;

import java.io.File;

public class Dir {
	
	public static void mkdir(String path){
	    File dir=new File(path);
	    if(dir.exists()) {
	    	System.out.println("File exists");
	    }else {
	    	dir.mkdir();
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
	    	}else {
	    		System.out.println("Directory not empty");
	    	}
	    }else {
	    	System.out.println("No such file or directory");
	    }
	        
	}

}
