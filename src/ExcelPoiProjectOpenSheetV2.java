import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ExcelPoiProjectOpenSheetV2 {
	
	public static JFrame f;
	public static DateTestingPanel p;

	//public static FileInputStream myExcelFile = null;
	//public static HSSFWorkbook workbook = null;
	//public static HSSFSheet worksheet = null;
	//public static POIFSFileSystem myFileSystem;  // from http://stackoverflow.com/questions/6530191/how-to-read-all-cell-value-using-apache-poi
	
	public static void main(String[] args) {
		
		
		f  = new JFrame ("Testing for the Android Phone App");
		f.setSize( 400, 200);
		p = new DateTestingPanel(400, 200);
		f.add(p);
		
		f.setVisible(true);
		
		System.out.println("Hello from top of POI program");

		
		//For Testing Times
		//String[] dayString = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		//String[] hourString = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };
		//String[] minuteString = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "59"};
	
		//ArrayList<String> classInfo;
		// try {
	        
			 //NOTICE THE FILE HAS TO BE SAVED IN A 97_2003 form of Excel to work.....  
			// myExcelFile = new FileInputStream(new File("c:\\users\\christopherroche\\My Documents\\six_day_week.xls"));

			// /** Create a POIFSFileSystem object**/
			// myFileSystem = new POIFSFileSystem(myExcelFile);

			 ///** Create a workbook using the File System**/
			 // workbook = new HSSFWorkbook(myFileSystem);
			  
			//  System.out.println("Hi we opened up a workBook in Main");
			 
			  
			  //DO READSHEET TESTING
	         //   worksheet = workbook.getSheet("Monday"); 
	         //   doReadSheet();
	         //   worksheet = workbook.getSheet("Tuesday"); 
	         //   doReadSheet();
			  
			  //Now Working with GetTheClass()
			  //getTheClass("May" "18", "00", "00");
			  
			 // String currentHourString;
			 // String currentMinuteString;
			 /* 
			  for(int i = 0; i < hourString.length; ++i){
					for(int j = 0; j < minuteString.length; ++j){
						currentHourString = hourString[i];
						//currentHourString = "8";
						currentMinuteString = minuteString[j]; 
						//System.out.println("About to check class Row for: " + currentHourString +":" + currentMinuteString);
						classInfo = getTheClass("MonthPlaceHolder", "DayPlaceHolder", "Wednesday", currentHourString, currentMinuteString);  
						System.out.println("At "+ currentHourString + ":" +currentMinuteString +
								", the class period is : " + classInfo.get(0) +", the color is: " + classInfo.get(1));
					}
				}  */
	            
	      /*      
	            
	        } catch (IOException e) {
	        	System.out.println("Problem finding the file!!!");
	            e.printStackTrace();
	        } finally {
	            if (myExcelFile != null) {
	                try {
	                    //myExcelFile.flush(); Works for output, not input
	                    myExcelFile.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }  */
	}
	
	
	
	

	
	
	
	

	//public static ArrayList<String> getTheClass(String month, String date, String weekDay,  String hour, String minute){
		
		// This assumes that a constructor has created an object where a spreadsheet file is open and now we just have to get the right worksheet
		
	//	ArrayList<String> cInfo;
	//	int whatRow =-1;
		
		//System.out.println("Hello in getTheClass, just before the try...");
	//	try{
			
		//	worksheet = workbook.getSheet(weekDay);
			//System.out.println("we got the worksheet for " + weekDay);
			
		//	cInfo = getClassInfo(hour, minute);  
			
			
			
		
		//}  catch (Exception e){

		//	System.out.println("Error  In GetTheClass --  Erro in opening up the worksheet");
		//	cInfo = new ArrayList<String>();
		//	cInfo.add("Error");
		//	cInfo.add("Error in getTheClass");
		//}
		//return cInfo;
		
	//}
	
	
	
	//public static ArrayList<String> getClassInfo (String hour, String minute){
		
		//ArrayList<String> classInfoStuff = new ArrayList<String>();
		
		//int startHourValue=0, startMinuteValue=0;
		//int endHourValue=0, endMinuteValue=0;
		
		//String cellValue = null;
		//HSSFRow row = null; 
		
		//System.out.println("Hi in top of getRowWithTime hourString is: " + hour + ",  minuteString is: " + minute);
		//int hourWeAreLookingFor = Integer.parseInt(hour);
		//int minuteWeAreLookingFor = Integer.parseInt(minute);
		
		//System.out.println("Hi in getRowWithTime, hourWeAreLookingFor " + hourWeAreLookingFor + " minuteWeAreLookingFor " + minuteWeAreLookingFor);
		//int rowWithTime = -1;
		
		//int totalRows = worksheet.getLastRowNum();
		//System.out.println("In Get Rows, the totalRows for the Worksheet is " + totalRows);
		//Row 0 is a Title of the sheet 
		//Row 1 is header information
		//int counter = 2;
		//boolean done = false;
		
		
		
		//while (!done){
			
				//System.out.println("In loop getting row, counter is " + counter);
			//	 row = worksheet.getRow(counter);
				
					
				//try{
					//HSSFCell cellStartHour = row.getCell(0);
					//HSSFCell cellStartMinute = row.getCell(1);
					//HSSFCell cellEndHour = row.getCell(2);
					//HSSFCell cellEndMinute = row.getCell(3);
					
					//startHourValue =  (int)cellStartHour.getNumericCellValue();
					//startMinuteValue = (int)cellStartMinute.getNumericCellValue();
					//endHourValue = (int)cellEndHour.getNumericCellValue();
					//endMinuteValue = (int)cellEndMinute.getNumericCellValue();
					
					
					//System.out.println("Class is from " + startHourValue + ":" + startMinuteValue + " to "
					//+ endHourValue + ":" + endMinuteValue);
					
					
					
			//	} catch (Exception e){
			//		System.out.println("Couldn't open cell " + counter);
					
			//	}
				
				//end loop stuff
				//First see if you have the time
				
				/*System.out.println("At the Check checking Start: " + startHourValue + ":" + startMinuteValue +
						" against " + hourWeAreLookingFor + ":" + minuteWeAreLookingFor + " and " +
						endHourValue + ":" + endMinuteValue);
				*/
				
				//int startTimeInMinutes = startHourValue*60 + startMinuteValue;
				//int timeWeSeekInMinutes = hourWeAreLookingFor*60 + minuteWeAreLookingFor;
				//int endTimeInMinutes = endHourValue*60 + endMinuteValue;
				
				//The NEW TEST
				//if(startTimeInMinutes <= timeWeSeekInMinutes && timeWeSeekInMinutes <= endTimeInMinutes){
				
						
					/*	System.out.println("THERE IS A MATCH WERE START IS " + startHourValue + ":" + startMinuteValue +
								" Time to check is " + hourWeAreLookingFor + ":" + minuteWeAreLookingFor + " and END is " +
								endHourValue + ":" + endMinuteValue);
					*/
					
					//	HSSFCell periodInfo = row.getCell(4);
						//HSSFCell periodColor= row.getCell(5);
						//classInfoStuff.add(periodInfo.getRichStringCellValue().getString());
						//classInfoStuff.add(periodColor.getRichStringCellValue().getString());
						//rowWithTime=counter;
						//done=true;
					//}
				//}
				//Then see if you are out of rows to look at	
				//if (counter < totalRows ){
				//	counter++;
				//} else {
				//	done = true;
				//}
			//} //end of while
				
			
		//if(rowWithTime <0 ){
		//	classInfoStuff.add("Error from GetClassInfo in finding the class");
		//	classInfoStuff.add("None");
		//}
		
		
		//return classInfoStuff;
	//}
}
	
	


/*  THIS WAS FOR TESTING>...
public static void doReadSheet(){
	
	System.out.println("Hi in top of doReadSheet");
	int TotalRows = worksheet.getLastRowNum();
	System.out.println("The total number of rows is " + TotalRows);
	String cellValue = null;
	HSSFRow row = null;

	
	
	
	for (int j = 0; j < TotalRows; j++) {
		 row = worksheet.getRow(j);
		
		int rowLenght = row.getPhysicalNumberOfCells();
		System.out.println("The PhysicalNumberOfCells is " + rowLenght);
	
		for (int i = 0; i < rowLenght; ++i){
	
			
		try{
			HSSFCell cell = row.getCell( i); // date in the cell '8/1/2009'
			if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
	
			    cellValue = cell.getRichStringCellValue().getString();
			}
			if( cell.getCellType() ==HSSFCell.CELL_TYPE_NUMERIC){
			    cellValue = new Double(cell.getNumericCellValue()).toString();
			  
			}
			System.out.println("Cell Value is "+ cellValue);
		} catch (Exception e){
			System.out.println("Couldn't open cell " + i);
			
		}
	}// end of i loop
} //end of j loop

	//HSSFCell theCell = row1.getCell(2, null);
	//String word = theCell.getStringCellValue();
	//System.out.println("The value of cell 0 in row 1 is: " + word);
	
	//CellReference cellReference = new CellReference("B3"); 
	//Row row = worksheet.getRow(cellReference.getRow());
	//Cell cell = row.getCell(cellReference.getCol()); 
	
	//double w = cell.getStringCellValue();
	//System.out.println("The value of cell 0 in row 1 is: " + w);
		
	//HSSFCell cellE1 = row1.getCell(4);
	//String firstName = cellE1.getStringCellValue();	 
	//HSSFCell cellF1 = row1.getCell(5);
	//String lastName = cellE1.getStringCellValue();	
	//System.out.println("Hello "+ firstName + " " + lastName);
	}
*/


