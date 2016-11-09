package common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.struts.upload.FormFile;

import model.bean.CauHoi;
import model.bean.PhuongAn;

public class Common {

	/**
	 * lưu file vào server
	 * 
	 * @param file
	 *            FormFile
	 * @param fileName
	 *            tên file
	 * @param filePath
	 *            đường dẫn
	 * @return
	 */
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

	/**
	 * ramndom list cau hoi
	 * 
	 * @param listCauHoi
	 * @return
	 */
	public static ArrayList<CauHoi> randomCauHoi(ArrayList<CauHoi> listCauHoi) {
		long seed = System.nanoTime();
		Collections.shuffle(listCauHoi, new Random(seed));
		return listCauHoi;
	}

	/**
	 * ramndom list phuong an
	 * 
	 * @param listPA
	 * @return
	 */
	public static ArrayList<PhuongAn> randomPhuongAn(ArrayList<PhuongAn> listPA) {
		long seed = System.nanoTime();
		Collections.shuffle(listPA, new Random(seed));
		return listPA;
	}
}
