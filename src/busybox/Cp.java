package busybox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cp{	
	public static void cp(String SOURCE,String DEST){
		File root = new File(SOURCE);
		File tar = new File(DEST);
		if(root.isDirectory()&&tar.isDirectory()){
			String rname = root.getName();
			tar = new File(tar,rname);
			tar.mkdir();
			cpr(root,tar);	//开始复制
		}else if(root.exists()){
			cp(root,tar);
		}else{
			System.out.println("Error...");
		}
	}
	
	private static void cpr(File root,File tar){
		File[] files = root.listFiles();
		//对文件夹中的文件进行判断
		for(File f : files){
			String fname = f.getName();
			File target = new File(tar,fname);
			if(f.isFile()){//是文件，直接调用复制文件的方法
					cp(f,target);
			}else{//是文件夹，创建文件夹，并继续复制文件夹中的文件
				target.mkdir();
				cpr(f,target);	//递归调用copy方法
			}
		}
	}
	
	private static void cp(File f ,File t){
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try{
			System.out.print("Copying..."+f.getName()+"--");
			fis = new FileInputStream(f);
			fos = new FileOutputStream(t);
			int len = 0;
			byte[] buf = new byte[1024];
			String rate = "";//用于记录已传输的文件大小
			while((len=fis.read(buf))!=-1){
				fos.write(buf,0,len);
				for (int i=0;i<rate.length();i++){//消除之前的rate
					System.out.print("\b");
				}
				rate = (float)Math.round((t.length()*1.0/f.length())*1000)/10+"%";//更新rate
				System.out.print(rate);
			}
			System.out.print("\b\b\b\b\b\b\b\b");
			System.out.println("--finish.\n");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try{	
					fis.close();	
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try{	
					fos.close();	
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}	
		
	}
}
