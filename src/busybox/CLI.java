package busybox;

public class CLI {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		//System.out.println(repeatString(10));
		//Tree.tree("E:\\test");
		//Ls.ls("E:\\test");
		//Ls.test();
		//Dir.rmdir("E:\\test\\mkdair");
		//Cp.cp("E:\\test\\1.txt","E:\\test\\3.txt");
		String cipher = Encrypt.encryptt("test123654", "thisisa3deskey11thisisa3");
		System.out.println(cipher);
		String text = Encrypt.decryptt(cipher, "thisisa3deskey11thisisa3");
		System.out.println(text);
		Encrypt.encryptf("E:\\test\\tp_p72_hmm_en.pdf","E:\\test\\5.txt", "thisisa3deskey11thisisa3");
		Encrypt.decryptf("E:\\test\\5.txt","E:\\test\\44.pdf", "thisisa3deskey11thisisa3");
	}
	
}
