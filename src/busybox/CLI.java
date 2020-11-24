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
		File directory = new File("");//�趨Ϊ��ǰ�ļ���
		String nowpath = directory.getCanonicalPath();
		String[] gs;
		String[] gr;
		String[] ss;
		String cmd = "";
		while (!Objects.equals(cmd, "exit")){
			System.out.print(nowpath + ">");//��ȡ��׼��·��
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
						System.out.println("ָ��һ�����󲿷�ָ����ѭlinuxָ�����");
						System.out.println("�г���������help");
						System.out.println("�л�Ŀ¼��cd path");
						System.out.println("����·��ģʽ��cd global");
						System.out.println("���ƣ�cp old_path new_path");
						System.out.println("�½��ļ��У�mkdir path");
						System.out.println("ɾ���ļ��У�rmdir path");
						System.out.println("�������֣�enc content key");
						System.out.println("�����ļ���enc input output key");
						System.out.println("�������֣�dec ciphertext key");
						System.out.println("�����ļ���dec input output key");
						System.out.println("�г��ļ����ļ������򣩣�ls -l");
						System.out.println("�г��ļ����޸��������򣩣�ls -lt");
						System.out.println("�г��ļ�����С���򣩣�ls -lS");
						System.out.println("�ƶ���mv old_path new_path");
						System.out.println("ɾ����rm path");
						System.out.println("�г��ļ�����tree path");
						System.out.println("");
						System.out.println("֧��ʹ��grep��ɸѡls�����");
						break;
					default:
						System.out.println("δ֪�������������ȷ��ʽ");
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
