package stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataread {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Exceldata d= new Exceldata();
		ArrayList data=d.getdata("Purchaces");
		System.out.println(data.get(0));
		

}
}