package busybox;

import java.io.File;

public class Mv {
	 public static void mv(String oldpath,String newpath){
	 	if(!oldpath.equals(newpath)){
	 		File oldfile=new File(oldpath);
	 		if (oldfile.exists()||oldfile.isDirectory()){
				File newfile=new File(newpath);
				oldfile.renameTo(newfile);
				System.out.println("移动成功");
			}else{
				System.out.println("未找到该文件/文件夹");
			}
	 	}
	 }
}
