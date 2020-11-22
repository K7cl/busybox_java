package busybox;

import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class CLI {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
//		System.out.println(System.getProperty("user.dir").replace("\\","/"));
//		File directory = new File("");//设定为当前文件夹
		String[] ss;
		String cmd = "";
		while (!Objects.equals(cmd, "exit")){
			System.out.print(">");//获取标准的路径
			ss = s.nextLine().split(" ");
			cmd = ss[0];
			try {
				switch (cmd) {
					case "cp":
						Cp.cp(ss[1], ss[2]);
						break;
					case "mkdir":
						Dir.mkdir(ss[1]);
						break;
					case "rmdir":
						Dir.rmdir(ss[1]);
						break;
					case "enc":
						File enF = new File(ss[1]);
						if (enF.exists()) Encrypt.encryptf(ss[1], ss[2], ss[3]);
						else Encrypt.encryptt(ss[1], ss[2]);
						break;
					case "dec":
						File deF = new File(ss[1]);
						if (deF.exists()) Encrypt.decryptf(ss[1], ss[2], ss[3]);
						else Encrypt.decryptt(ss[1], ss[2]);
						break;
					case "ls":
						Ls.ls(ss[1]);
						break;
					case "mv":
						Mv.mv(ss[1], ss[2]);
						break;
					case "rm":
						Rm.rm(ss[1]);
						break;
					case "tree":
						Tree.tree(ss[1]);
						break;
					default:
						System.out.println("未知的命令，请输入正确格式");
				}
			}
			catch (Exception e){
				System.out.println("ERROR!");
			}
		}



		// TODO 自动生成的方法存根
		//System.out.println(repeatString(10));
		//Tree.tree("F:\\PlantsVsZombies");
		//Ls.ls("E:\\test");
		//Ls.test();
		//Dir.rmdir("E:\\test\\mkdair");
		//Cp.cp("E:\\test\\1.txt","E:\\test\\3.txt");
		/*
		String cipher = Encrypt.encryptt("test123654", "thisisa3deskey11thisisa3");
		System.out.println(cipher);
		String text = Encrypt.decryptt(cipher, "thisisa3deskey11thisisa3");
		System.out.println(text);
		Encrypt.encryptf("E:\\test\\tp_p72_hmm_en.pdf","E:\\test\\5.txt", "thisisa3deskey11thisisa3");
		Encrypt.decryptf("E:\\test\\5.txt","E:\\test\\44.pdf", "thisisa3deskey11thisisa3");
		 */
	}
	
}
