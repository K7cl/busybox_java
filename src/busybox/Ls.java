package busybox;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Ls extends CLI {

	public static void ls(String path) {
		//CLI.print(path);
		File file = new File(path);
		if (file.exists() || file.isDirectory()) {//�ж��ļ��Ƿ����
			File[] listFiles = file.listFiles();//��ȡ�ļ��µ����ļ�
			for (File f : listFiles) {
				if (f.getName().contains(keyword)) {
					System.out.printf("%- 10s\t%s\t%s", f.getName(), f.lastModified(), f.length());
				}
			}
		} else {
			CLI.print("δ�ҵ����ļ�/�ļ���");
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
		CLI.print("TEST OK!");
	}


	public static void lsS(String path) {
		//CLI.print(path);
		File file = new File(path);
		if (file.exists() || file.isDirectory()) {//�ж��ļ��Ƿ����
			File[] listFiles = file.listFiles();//��ȡ�ļ��µ����ļ�
			Arrays.sort(listFiles, new CompratorBySize());
			for (int i = 0; i < listFiles.length; i++) {

				CLI.print(listFiles[i].getName() + "\t\t\t" + listFiles[i].length());
			}
		} else {
			CLI.print("δ�ҵ����ļ�/�ļ���");
		}
	}

	public static void lsT(String path) {
		//System.out.println(path);
		File file = new File(path);
		if (file.exists() || file.isDirectory()) {//�ж��ļ��Ƿ����
			File[] listFiles = file.listFiles();//��ȡ�ļ��µ����ļ�
			Arrays.sort(listFiles, new CompratorByLastModified());
			for (File listFile : listFiles) {
				System.out.println(listFile.getName() + "\t\t\t" + new Date(listFile.lastModified()));
			}
		} else {
			System.out.println("δ�ҵ����ļ�/�ļ���");
		}

	}
}