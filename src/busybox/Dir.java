package busybox;

import java.io.File;

public class Dir {
	
	public static void mkdir(String path){
	    File dir=new File(path);
	    if(dir.exists()) {
	    	System.out.println("File exists");
	    }else {
	    	dir.mkdir();
	    	if (dir.isDirectory()) System.out.println("�����ɹ�");
	    	else System.out.println("����ʧ��");
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
				System.out.println("ɾ���ɹ�");
	    	}else {
	    		System.out.println("�ļ��в�Ϊ��");
	    	}
	    }else {
	    	System.out.println("δ�ҵ����ļ���");
	    }
	        
	}

}
