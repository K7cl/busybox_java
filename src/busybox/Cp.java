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
			cpr(root,tar);	//��ʼ����
		}else if(root.exists()){
			cp(root,tar);
		}else{
			System.out.println("Error...");
		}
	}
	
	private static void cpr(File root,File tar){

		File[] files = root.listFiles();
		//���ļ����е��ļ������ж�
		for(File f : files){
			String fname = f.getName();
			File target = new File(tar,fname);
			if(f.isFile()){//���ļ���ֱ�ӵ��ø����ļ��ķ���
					cp(f,target);
			}else{//���ļ��У������ļ��У������������ļ����е��ļ�
				target.mkdir();
				cpr(f,target);	//�ݹ����copy����
			}
		}
	}*/
	
	public static void cp(String oldpath,String newpath){
		if(Objects.equals(oldpath, newpath)){
			System.out.println("����ʧ��!\n����ַ����ͬ��");
			return;
		}
		File f = new File(oldpath);
		File t = new File(newpath);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try{
			System.out.print("���ڸ���"+f.getName()+"...\n���ȣ�");
			fis = new FileInputStream(f);
			fos = new FileOutputStream(t);
			int len = 0;
			float speed = 0;
			float needTime = 0;
			long startTime = System.currentTimeMillis();
			byte[] buf = new byte[1024];
			String rate = "";//���ڼ�¼�Ѵ�����ļ���С
			while((len=fis.read(buf))!=-1){
				fos.write(buf,0,len);
				long nowTime = System.currentTimeMillis();
				int lenOfLastRate = rate.length();
				try{speed = (float)Math.round(t.length()*1.0/(nowTime-startTime)/1.024)/100;}catch (Exception e){ speed = 0; }	//����speed
				needTime = (float)Math.round((f.length()-t.length())/speed/10240)/10;
				rate = ((float)Math.round((t.length()*1.0/f.length())*1000)/10+"%\t�ٶȣ�" + speed + "kb/s\tԤ��ʣ��ʱ�䣺"+needTime+"s");//����rate
				for (int i=0;i<lenOfLastRate;i++){												//ɾ��֮ǰ��rate
					System.out.print("\b");
				}
				System.out.print(rate);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("\n������ɣ�����ʱ" + (float)Math.round((endTime-startTime)/10.0)/100 + "s");
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
