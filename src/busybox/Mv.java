package busybox;

import java.io.File;

public class Mv {
	 public static void mv(String oldpath,String newpath){
	 	if(!oldpath.equals(newpath)){
	 		File oldfile=new File(oldpath);
	 		if (oldfile.exists()||oldfile.isDirectory()){
				File newfile=new File(newpath);
				oldfile.renameTo(newfile);
				System.out.println("�ƶ��ɹ�");
			}else{
				System.out.println("δ�ҵ����ļ�/�ļ���");
			}
	 	}
	 }
}
