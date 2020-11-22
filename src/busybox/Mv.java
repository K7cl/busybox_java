package busybox;

import java.io.File;

public class Mv {
	 public void mv(String oldpath,String newpath){
	     if(!oldpath.equals(newpath)){
	         File oldfile=new File(oldpath);
	         File newfile=new File(newpath);
	         oldfile.renameTo(newfile);
	         }
	 }
}
