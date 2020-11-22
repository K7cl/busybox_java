package busybox;

import java.io.File;

public class Tree {
	private static int counti = 0;
	
	private static String repeatString(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
                sb.append("   ");
        }
        return sb.substring(0, sb.length());
	}
	
	public static void tree(String path) {
		//System.out.println(path);
		File file =new File(path);
	    if(file.exists() || file.isDirectory()){//判断文件是否存在
	        File[] listFiles =file.listFiles();//获取文件下的子文件
	        int countii = 1;
	        for (File f : listFiles) {
	            System.out.print(repeatString(counti));
	            if(countii == listFiles.length) {
	            	System.out.print("└─");
	            }else {
	            	System.out.print("├─");
	            }
	            countii ++;
	            if(f.isDirectory()){//判断file是否是文件夹
	                System.out.println(f.getName());
	                counti++;
	                tree(f.getAbsolutePath());//文件夹就继续遍历下的子文件
	                counti--;
	            }else if(f.isFile()){
	                System.out.println(f.getName());
	            }
	        }
	    }
	    else {
	    	System.out.println("未找到该文件夹");
	    }
	}

}
