package busybox;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Ls extends CLI {

	public static void ls(String path) {
		//CLI.print(path);
		File file = new File(path);
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		if (file.exists() || file.isDirectory()) {//判断文件是否存在
			File[] listFiles = file.listFiles();//获取文件下的子文件
			Comparator<File> cmp = new cmp();
			if(arg1.equals("-lt")) {
				cmp = new CompratorByLastModified();
			}
			else if(arg1.equals("-lS")){
				cmp = new CompratorBySize();
			}
			Arrays.sort(listFiles,cmp);
			for (File f : listFiles) {
				if (f.getName().contains(keyword)) {
					String FName;
					if (f.getName().length() > 9) {
						FName = f.getName().substring(0, 8);
						FName += "…";
					} else FName = f.getName();
					Date d = new Date(f.lastModified());
					System.out.printf("%-12s\t%s\t\t%s\n", FName, df.format(d), unitConversion(f.length()));
				}
			}
		} else {
			CLI.print("未找到该文件/文件夹");
		}
	}

	static class cmp implements Comparator<File> {
		public int compare(File f1,File f2){return 0;}
	}

	static String unitConversion(long size) {
		if (size < 1024) return (Long.toString(size));
		size /= 1024;
		if (size < 1024) return (size + "K");
		size /= 1024;
		if (size < 1024) return (size + "M");
		size /= 1024;
		if (size < 1024) return (size + "G");
		else return "Size out of range";
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