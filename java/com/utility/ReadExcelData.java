package com.utility;

import java.io.File;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelData {
	public static String getParticularData(int rowValue, int columnValue) {
		String data = null;
		try {
			File file = new File("C:\\Users\\Test\\Downloads\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Read");
			Row row = sheet.getRow(rowValue);
			Cell cell = row.getCell(columnValue);

			DataFormatter dataFormate = new DataFormatter();
			data = dataFormate.formatCellValue(cell);
			System.out.println(data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public static void main(String[] args) {
		getParticularData(1,0);
	}
}
