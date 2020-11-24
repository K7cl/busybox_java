package busybox;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Ls {

	public static void ls(String path) {
		//System.out.println(path);
		File file =new File(path);
        if(file.exists() || file.isDirectory()){//�ж��ļ��Ƿ����
            File[] listFiles =file.listFiles();//��ȡ�ļ��µ����ļ�
            for (File f : listFiles) {
                System.out.println(f.getName());
            }
        }
        else {
        	System.out.println("δ�ҵ����ļ�/�ļ���");
        }
	}
	
	public static void lst(String path) {
		//System.out.println(path);
		File file =new File(path);
        if(file.exists() || file.isDirectory()){//�ж��ļ��Ƿ����
            File[] listFiles =file.listFiles();//��ȡ�ļ��µ����ļ�
    		Arrays.sort(listFiles, new CompratorByLastModified());
    		for (int i = 0; i < listFiles.length; i++) {
    			System.out.println(listFiles[i].getName()+"\t\t\t"+new Date(listFiles[i].lastModified()));
    		}
        }
        else {
        	System.out.println("δ�ҵ����ļ�/�ļ���");
        }
	}
	static class CompratorByLastModified implements Comparator<File> {
		public int compare(File f1, File f2) {
			long diff = f1.lastModified() - f2.lastModified();
			if (diff > 0)
			return -1;//�����������
			else if (diff == 0)
			return 0;
			else
			return 1;//�����������
		}
		public boolean equals(Object obj) {
		return true;
		}
	}
	
	public static void lsS(String path) {
		//System.out.println(path);
		File file =new File(path);
        if(file.exists() || file.isDirectory()){//�ж��ļ��Ƿ����
            File[] listFiles =file.listFiles();//��ȡ�ļ��µ����ļ�
    		Arrays.sort(listFiles, new CompratorBySize());
    		for (int i = 0; i < listFiles.length; i++) {
    			System.out.println(listFiles[i].getName()+"\t\t\t"+listFiles[i].length());
    		}
        }
        else {
        	System.out.println("δ�ҵ����ļ�/�ļ���");
        }
	}
	static class CompratorBySize implements Comparator<File> {
		public int compare(File f1, File f2) {
			long diff = f1.length() - f2.length();
			if (diff > 0)
			return -1;//�����������
			else if (diff == 0)
			return 0;
			else
			return 1;//�����������
		}
		public boolean equals(Object obj) {
		return true;
		}
	}
	
	public static void test() {
		System.out.println("TEST OK!");
	}

}
