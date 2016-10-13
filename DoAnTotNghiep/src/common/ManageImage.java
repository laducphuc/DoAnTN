package common;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.upload.FormFile;

public class ManageImage {

	public static String luuAnhDaiDien(FormFile file, HttpServletRequest request, ActionServlet servlet) {

		String filePath = servlet.getServletContext().getRealPath("/")
				+ "avata";

		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		String fileName = file.getFileName();
		File newFile = new File(filePath, fileName);
		if (!("").equals(fileName)) {
			//System.out.println("filePath" + filePath + "fileName=1" + fileName);
			while (newFile.exists()) {
				fileName = fileName.substring(0, fileName.indexOf("."))
						+ "a"
						+ fileName.substring(fileName.indexOf(".") ,
								fileName.length());
			//	System.out.println(""+fileName);
				newFile= new File(filePath,fileName);
			}
			if (!newFile.exists()) {
				try {
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(file.getFileData());
					fos.flush();
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("uploadFilePath", newFile.getAbsoluteFile());
			request.setAttribute("uploadFileName", newFile.getName());
			String myPath = "E:\\ki 8\\gv\\DoAnTotNghiep\\WebContent\\avata";
			File localFile = new File(myPath, fileName);
			try {
				FileUtils.copyFile(newFile, localFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//System.out.println("file Name" + fileName);
		return fileName;
	}

	public static void xoaAnhDaiDien(String anh, ActionServlet servlet) {
		try {
			String filePathHost = servlet.getServletContext().getRealPath(
					"/")
					+ "avata\\" + anh;
			String filePathLocal = "E:\\ki 8\\gv\\DoAnTotNghiep\\WebContent\\avata\\"
					+ anh;
			File file1 = new File(filePathHost);
			File file2 = new File(filePathLocal);
	//		System.out.println("" + filePathHost);
	//		System.out.println("" + filePathLocal);
			if (file1.exists()) {
				file1.delete();
			}
			if (file2.exists()) {
				file2.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
