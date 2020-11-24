package busybox;

import java.io.File;

public class Mv {
	public static void mv(String oldpath,String newpath){
		if(!oldpath.equals(newpath)){
			File oldfile=new File(oldpath);
			if (oldfile.exists()||oldfile.isDirectory()){
				File newfile=new File(newpath);
				if (oldfile.isDirectory() && newfile.isDirectory()) {
					File[] listFiles =oldfile.listFiles();//��ȡ�ļ��µ����ļ�
					for (File f : listFiles) {
						mv(oldpath + f.getName(),newpath + f.getName());
					}
				}
				oldfile.renameTo(newfile);
				System.out.println("�ƶ��ɹ�");
			}else{
				System.out.println("δ�ҵ����ļ�/�ļ���");
			}
		}
	}
}
