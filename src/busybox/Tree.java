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
	    if(file.exists() || file.isDirectory()){//�ж��ļ��Ƿ����
	        File[] listFiles =file.listFiles();//��ȡ�ļ��µ����ļ�
	        int countii = 1;
	        for (File f : listFiles) {
	            System.out.print(repeatString(counti));
	            if(countii == listFiles.length) {
	            	System.out.print("����");
	            }else {
	            	System.out.print("����");
	            }
	            countii ++;
	            if(f.isDirectory()){//�ж�file�Ƿ����ļ���
	                System.out.println(f.getName());
	                counti++;
	                tree(f.getAbsolutePath());//�ļ��оͼ��������µ����ļ�
	                counti--;
	            }else if(f.isFile()){
	                System.out.println(f.getName());
	            }
	        }
	    }
	    else {
	    	System.out.println("δ�ҵ����ļ���");
	    }
	}

}
