package busybox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Cp{
	/*
	public static void cp(String oldpath, String newpath){
		File root = new File(oldpath);
		File tar = new File(newpath);
		if(Objects.equals(oldpath, newpath)){
			System.out.println("ERROR!");
			return;
		}
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
	}*/
	
	public static void cp(String oldpath,String newpath){
		if(Objects.equals(oldpath, newpath)){
			System.out.println("复制失败!\n两地址是相同的");
			return;
		}
		File f = new File(oldpath);
		File t = new File(newpath);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try{
			System.out.println("正在复制"+f.getName()+"...");
			fis = new FileInputStream(f);
			fos = new FileOutputStream(t);
			int len = 0;
			long startTime = System.currentTimeMillis();
			byte[] buf = new byte[1024];
			String rate = "";//用于记录已传输的文件大小
			while((len=fis.read(buf))!=-1){
				fos.write(buf,0,len);
				long nowTime = System.currentTimeMillis();
				long speed = t.length()/(nowTime-startTime);for (int i=0;i<rate.length();i++){//消除之前的rate
					System.out.print("\b");
				}
				rate = ((float)Math.round((t.length()*1.0/f.length())*1000)/10+"%\t速度：" + speed + "kb/s");//更新rate
				System.out.print(rate);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("\n复制完成，共用时" + (endTime-startTime) + "ms");
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
