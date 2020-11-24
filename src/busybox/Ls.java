package busybox;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Ls extends CLI {

	public static void ls(String path) {
		//CLI.print(path);
		File file = new File(path);
		if (file.exists() || file.isDirectory()) {//判断文件是否存在
			File[] listFiles = file.listFiles();//获取文件下的子文件
			for (File f : listFiles) {
				if (f.getName().contains(keyword)) {
					System.out.printf("%- 10s\t%s\t%s", f.getName(), f.lastModified(), f.length());
				}
			}
		} else {
			CLI.print("未找到该文件/文件夹");
		}
	}


	static class CompratorByLastModified implements Comparator<File> {
		public int compare(File f1, File f2) {
			long diff = f1.lastModified() - f2.lastModified();
			if (diff > 0)
				return -1;//倒序正序控制
			else if (diff == 0)
				return 0;
			else
				return 1;//倒序正序控制
		}

		public boolean equals(Object obj) {
			return true;
		}
	}


	static class CompratorBySize implements Comparator<File> {
		public int compare(File f1, File f2) {
			long diff = f1.length() - f2.length();
			if (diff > 0)
				return -1;//倒序正序控制
			else if (diff == 0)
				return 0;
			else
				return 1;//倒序正序控制
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
		if (file.exists() || file.isDirectory()) {//判断文件是否存在
			File[] listFiles = file.listFiles();//获取文件下的子文件
			Arrays.sort(listFiles, new CompratorBySize());
			for (int i = 0; i < listFiles.length; i++) {

				CLI.print(listFiles[i].getName() + "\t\t\t" + listFiles[i].length());
			}
		} else {
			CLI.print("未找到该文件/文件夹");
		}
	}

	public static void lsT(String path) {
		//System.out.println(path);
		File file = new File(path);
		if (file.exists() || file.isDirectory()) {//判断文件是否存在
			File[] listFiles = file.listFiles();//获取文件下的子文件
			Arrays.sort(listFiles, new CompratorByLastModified());
			for (File listFile : listFiles) {
				System.out.println(listFile.getName() + "\t\t\t" + new Date(listFile.lastModified()));
			}
		} else {
			System.out.println("未找到该文件/文件夹");
		}

	}
}