package busybox;

import java.io.File;

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
	
	public static void test() {
		System.out.println("TEST OK!");
	}

}
