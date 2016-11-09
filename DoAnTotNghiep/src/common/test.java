package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.bean.CauHoi;

public class test {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());
		CauHoi cauHoi;
		ArrayList<CauHoi> list = new ArrayList<CauHoi>();
		for (int i = 0; i < 10; i++) {
			cauHoi = new CauHoi();
			cauHoi.setMaCauHoi(i + "");
			cauHoi.setDapAn("dap an " + i);
			list.add(cauHoi);
		}
		String fileName = "E:/DATN/DataTest/test1.xls";
		test t = new test();
		t.readExcel(fileName);
	}

	public static ArrayList<CauHoi> random(ArrayList<CauHoi> listCauHoi) {
		long seed = System.nanoTime();
		Collections.shuffle(listCauHoi, new Random(seed));
		return listCauHoi;
	}

	public void readExcel(String fileName) {
		// final String fileName="E:/DATN/DataTest/test1.xls";
		Workbook workbook;
		try {
			// create workbook to open file
			workbook = Workbook.getWorkbook(new File(fileName));
			// get sheet want read
			Sheet sheet = workbook.getSheet(0);
			// get number row and col contain data
			int rows = sheet.getRows();
			int cols = sheet.getColumns();

			System.out.println("Data in file:");
			// read data in each cell
			Cell cell = sheet.getCell(0, 0);
			System.out.print("Ma cau Hoi:" + cell.getContents() + "\t");
			for (int row = 1; row < rows; row++) {
				Cell cell1 = sheet.getCell(0, row);
				System.out.println("Cau hoi:" + row + "\t" + cell1.getContents());
				System.out.print("dap an:");
				for(cols=1;cols<5;cols++){
				Cell cell2 = sheet.getCell(cols, row);
				System.out.print( cell2.getContents() + "\t");
				}
				System.out.println("\n");
			}
			// close
			workbook.close();
		} catch (BiffException e) {
			System.out.println("File not found\n" + e.toString());
		} catch (IOException e) {
			System.out.println("File not found\n" + e.toString());
		}
	}
}
