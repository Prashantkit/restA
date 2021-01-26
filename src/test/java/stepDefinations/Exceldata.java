package stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	public ArrayList<String> getdata(String testcaseName) throws IOException {
		
		ArrayList<String> a= new ArrayList<String>();
				FileInputStream fis= new FileInputStream("D:\\Testing.xlsx");
				
				XSSFWorkbook workbook= new XSSFWorkbook(fis);
				int count=workbook.getNumberOfSheets();
				for (int i=0;i<count;i++) {
					if(workbook.getSheetName(i).equalsIgnoreCase("Test")) {
					XSSFSheet sheet=workbook.getSheetAt(i);
					Iterator<Row> rows = sheet.iterator();
					Row firstrow = rows.next();
					Iterator <Cell> cell=firstrow.cellIterator();
					int k=0;
					int coloumn=0;
					while(cell.hasNext()) {
						Cell value=cell.next();
						
						if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
							coloumn=k;
							
							k++;
						}
					}
					System.out.println(coloumn);
					while(rows.hasNext()) {
						Row r=rows.next();
						if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
							Iterator<Cell>cv=r.cellIterator();
							while(cv.hasNext()) {
								System.out.println(cv.next().getStringCellValue());
								a.add(cv.next().getStringCellValue());
							}
						}
						
					}
				}
				}
				return a;
				
			}

		
	}

