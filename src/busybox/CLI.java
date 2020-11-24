package busybox;

import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class CLI {
	public static String arg1;
	public static String arg2;
	public static String arg3;
	public static String keyword = "";

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		File directory = new File("");//设定为当前文件夹
		String nowpath = directory.getCanonicalPath();
		String[] gs;
		String[] gr;
		String[] ss;
		String cmd = "";
		while (!Objects.equals(cmd, "exit")){
			System.out.print(nowpath + ">");//获取标准的路径
			gs = s.nextLine().split("\\|");
			ss = gs[0].split(" ");
			try {
				gr = gs[1].split(" ");
				if (gr[1].equals("grep")) {
					keyword = gr[2];
				}
			}catch(Exception e) {}
			cmd = ss[0];
			arg1 = "";
			arg2 = "";
			arg3 = "";
			switch (ss.length) {
			case 4:
				arg3 = ss[3];
			case 3:
				arg2 = ss[2];
			case 2:
				arg1 = ss[1];
			}
			
			try {
				switch (cmd) {
					case "cd"://
						if (ss[1].equals("..")) {
							nowpath = cdparent(nowpath);
						}else if (ss[1].equals("global")) {
							nowpath = "";
						}else {
							nowpath = ss[1];
						}
						break;
					case "cp":
						Cp.cp(nowpath + "\\" + arg1, nowpath + "\\" + arg2);
						break;
					case "mkdir":
						Dir.mkdir(nowpath + "\\" + arg1);
						break;
					case "rmdir":
						Dir.rmdir(nowpath + "\\" + arg1);
						break;
					case "enc":
						File enF = new File(nowpath + "\\" + arg1);
						if (enF.exists()) Encrypt.encryptf(nowpath + "\\" + arg1, nowpath + "\\" + arg2, arg3);
						else Encrypt.encryptt(arg1, arg2);
						break;
					case "dec":
						File deF = new File(nowpath + "\\" + arg1);
						if (deF.exists()) Encrypt.decryptf(nowpath + "\\" + arg1, nowpath + "\\" + arg2, arg3);
						else Encrypt.decryptt(arg1, arg2);
						break;
					case "ls":
						Ls.ls(nowpath + "\\" + arg2);
						break;
					case "mv":
						Mv.mv(nowpath + "\\" + arg1, nowpath + "\\" + arg2);
						break;
					case "rm":
						Rm.rm(nowpath + "\\" + arg1);
						break;
					case "tree":
						Tree.tree(nowpath + "\\" + arg1);
						break;
					case "help":
						System.out.println("指令一览表：大部分指令遵循linux指令规则");
						System.out.println("列出本帮助：help");
						System.out.println("切换目录：cd path");
						System.out.println("绝对路径模式：cd global");
						System.out.println("复制：cp old_path new_path");
						System.out.println("新建文件夹：mkdir path");
						System.out.println("删除文件夹：rmdir path");
						System.out.println("加密文字：enc content key");
						System.out.println("加密文件：enc input output key");
						System.out.println("解密文字：dec ciphertext key");
						System.out.println("解密文件：dec input output key");
						System.out.println("列出文件（文件名排序）：ls -l");
						System.out.println("列出文件（修改日期排序）：ls -lt");
						System.out.println("列出文件（大小排序）：ls -lS");
						System.out.println("移动：mv old_path new_path");
						System.out.println("删除：rm path");
						System.out.println("列出文件树：tree path");
						System.out.println("");
						System.out.println("支持使用grep来筛选ls的输出");
						break;
					default:
						System.out.println("未知的命令，请输入正确格式");
				}
			}
			catch (Exception e){
				System.out.println("ERROR!");
				System.out.println(e);
			}
		}
		s.close();
	}
	private static String cdparent(String path) {
		String[] paths = path.split("\\\\");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < paths.length - 1; i++) {
        	if (i == 0) {
        		sb.append(paths[i]);
        	}else {
        		sb.append("\\" + paths[i]);
        	}
        }
		String result = sb.substring(0, sb.length());
		return result;
	}
	public static void print(String text) {
		if (text.contains(keyword)) {
			System.out.println(text);
		}
	}
	
}
