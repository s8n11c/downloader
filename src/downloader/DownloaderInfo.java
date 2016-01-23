package downloader;
//working fine 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpUtils;
import javax.swing.SwingWorker;

public class DownloaderInfo {
static String fileUrl;
private InputStream inputstream;
 String filename ;
private HttpURLConnection httpconn;
private int contentLength;
downloaderface now;
public DownloaderInfo(downloaderface now) {
	// TODO Auto-generated constructor stub
	this.now=now;
}
public void downloadfile(String fileURL) throws IOException {
	try {
		URL url = new URL(fileURL);
		httpconn = (HttpURLConnection) url.openConnection();
		int respnsecode=httpconn.getResponseCode();
		
		if(respnsecode==HttpURLConnection.HTTP_OK){
		     String disposition = httpconn.getHeaderField("Content-Disposition");
	            String contentType = httpconn.getContentType();
	            contentLength = httpconn.getContentLength();
	 
	            if (disposition != null) {
	                // extracts file name from header field
	                int index = disposition.indexOf("filename=");
	                if (index > 0) {
	                    filename = disposition.substring(index + 10,
	                            disposition.length() - 1);
	                }
	            } else {
	                // extracts file name from URL
	                filename = fileURL.substring(fileURL.lastIndexOf("/") + 1,
	                        fileURL.length());
	            }
	 
	            // output for debugging purpose only
	       //     System.out.println("Content-Type = " + contentType);
	         //   System.out.println("Content-Disposition = " + disposition);
	          //  System.out.println("Content-Length = " + contentLength);
	           // System.out.println("fileName = " + filename);
	 
	            // opens input stream from the HTTP connection
	            inputstream = httpconn.getInputStream();
		}else{
			if(this.now==null)
		System.out.println("connection refused .. go check for error ");	
			else{
				now.textField_2.setText("connection refused");
				
			
			}
		}
		
	
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	   public void disconnect() throws IOException {
	        inputstream.close();
	        httpconn.disconnect();
	    }
	 
	    public String getFileName() {
	        return this.filename;
	    }
	 
	    public int getContentLength() {
	        return this.contentLength;
	    }
	 
	    public InputStream getInputStream() {
	        return this.inputstream;
	    }
	    public static void main (String [] argz){
	    	String downloadurl="https://archlinux.cu.be/iso/2015.12.01/archlinux-2015.12.01-dual.iso",filename="/home/s0n1c/Documents";
	    	Downloader newer = new Downloader(downloadurl, filename);
	    	newer.dodownload();
	    }
	    public DownloaderInfo() {
			// TODO Auto-generated constructor stub
		}

}
class Downloader {
	Downloader(){}
	private final int bufferSize=5000;
	private String downloadedFile;
	private String saveDir;
	
	Downloader(String downloadurl,String filename){
			this.saveDir=filename;
			this.downloadedFile=downloadurl;
	}
	 
	void dodownload(){
		DownloaderInfo doinfo = new DownloaderInfo();
		try {
			doinfo.downloadfile(this.downloadedFile);
			System.out.println("the name :"+doinfo.getFileName()+"the size :"+doinfo.getContentLength());
			String savefilepath=saveDir+File.separator+doinfo.getFileName();
			InputStream inputstream = doinfo.getInputStream();
			
			FileOutputStream outputstream = new FileOutputStream(savefilepath);
			
			byte buffer [] = new byte[bufferSize];
			int bytesread=-1;
			long totalBytesRead = 0;
            int percentCompleted = 0;
            long fileSize = doinfo.getContentLength();
            while ((bytesread = inputstream.read(buffer)) != -1) {
                outputstream.write(buffer, 0, bytesread);
                totalBytesRead += bytesread;
                percentCompleted = (int) (totalBytesRead * 100 / fileSize);
     System.out.println(percentCompleted+"%");
           //   setProgress(percentCompleted);         
            }
            outputstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	 protected void done() {
	       System.out.println("downloaded done ! ");
	        
	    }  
	
}
