package com.heroes.service;






import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.Charset;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DownloadErrorException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;

@Service
public class DropBoxService
{
	
	
	final String accesToken = "ACCES_TOKEN";
	final String APP_NAME = "Heroes";
	DbxClientV2 client;
	public DropBoxService() 
	{
		DbxRequestConfig config = new DbxRequestConfig(APP_NAME);
		this.client = new DbxClientV2(config, accesToken);
		this.v1 = new DbxClientV1(config, accesToken);
	}
	public void uploadFile(MultipartFile file, String fileName)
	{
		try {
			//FileInputStream in = new FileInputStream(file);
			InputStream in = file.getInputStream();
			client.files().uploadBuilder("/" + fileName).uploadAndFinish(in);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UploadErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getFile(String filePath)
	{
			
				
				ByteArrayOutputStream outByte = new ByteArrayOutputStream();
				try {
					client.files().download("/" + filePath).download(outByte);
					byte[] byteOut = org.apache.commons.codec.binary.Base64.encodeBase64(outByte.toByteArray());
					outByte.close();
					return new String(byteOut);
				} catch (DbxException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	}
	public void deleteFile(String fileName)
	{
		try {
			client.files().delete("/" + fileName);
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
