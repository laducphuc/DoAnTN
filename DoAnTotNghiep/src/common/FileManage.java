package common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts.upload.FormFile;

public class FileManage {
	public static boolean saveFile(FormFile file, String fileName, String filePath) {
		if (file != null) {
			if (!("").equals(fileName)) {
				File newFile = new File(filePath, fileName);
				try {
					if (!newFile.exists()) {
						FileOutputStream fos = new FileOutputStream(newFile);
						fos.write(file.getFileData());
						fos.flush();
						fos.close();
						return true;
					} else {
						return false;
					}
				} catch (IOException e) {
					return false;
				}
			}
		}
		return false;
	}
}
