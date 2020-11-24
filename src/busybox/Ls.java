package busybox;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ls {

    public static class cmpName implements Comparator<File> {
        public int compare(File a,File b){
            return a.getName().compareTo(b.getName());
        }
    }
	public static void ls(String path) {
		//System.out.println(path);
		File file =new File(path);
        if(file.exists() || file.isDirectory()){//�ж��ļ��Ƿ����
            File[] listFiles =file.listFiles();//��ȡ�ļ��µ����ļ�
            if(listFiles!=null)
                Scanner s = new Scanner(System.in);
                switch (s = new Scanner(System.in);)

            Comparator<File> cName = new cmpName();
            Arrays.sort(listFiles,cName);
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
