package busybox;

import java.io.File;

public class Ls {

	public static void ls(String path) {
		//System.out.println(path);
		File file =new File(path);
        if(file.exists() || file.isDirectory()){//判断文件是否存在
            File[] listFiles =file.listFiles();//获取文件下的子文件
            for (File f : listFiles) {
                System.out.println(f.getName());
            }
        }
        else {
        	System.out.println("未找到该文件/文件夹");
        }
	}
	
	public static void test() {
		System.out.println("TEST OK!");
	}

}
