import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ExcelKnowledgeObject {
	
	public FileInputStream myExcelFile = null;
	public HSSFWorkbook workbook = null;
	public static HSSFSheet worksheet = null;
	public POIFSFileSystem myFileSystem = null;  // from http://stackoverflow.com/questions/6530191/how-to-read-all-cell-value-using-apache-poi
	public ArrayList<String> classInfo;

	
	//Variables to look at strings
	String currentDayString, currentHourString, currentMinuteString;
	
public ExcelKnowledgeObject(){
	
	 try {
       
		 //NOTICE THE FILE HAS TO BE SAVED IN A 97_2003 form of Excel to work.....  
		 myExcelFile = new FileInputStream(new File("c:\\users\\christopherroche\\My Documents\\six_day_week.xls"));

		 /** Create a POIFSFileSystem object**/
		 myFileSystem = new POIFSFileSystem(myExcelFile);

		 /** Create a workbook using the File System**/
		  workbook = new HSSFWorkbook(myFileSystem);
		  
		
           
           
           
       } catch (IOException e) {
       	System.out.println("Problem finding the file!!!  in Excel Constructor");
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
       }
	
}
	
	
	
public  ArrayList<String> getTheClass(String whatMonth, String whatDate, String whatWeekDay,  String whatHour, String whatMinute){
		
		// This assumes that a constructor has created an object where a spreadsheet file is open and now we just have to get the right worksheet
		
		ArrayList<String> cInfo;
		int whatRow =-1;
		
		//System.out.println("Hello in getTheClass, just before the try...");
		try{
			openTheCorrectWorkSheet(whatWeekDay);
			
			System.out.println("we got the worksheet for " + whatWeekDay);
			
			cInfo = getClassInfo(whatHour, whatMinute);  
			
			
			
		
		}  catch (Exception e){

			System.out.println("Error  In GetTheClass --  Erro in opening up the worksheet");
			cInfo = new ArrayList<String>();
			cInfo.add("Error");
			cInfo.add("Error in getTheClass");
		}
		return cInfo;
		
	}
	
	public static ArrayList<String> getClassInfo (String whatHour, String whatMinute){
		
		ArrayList<String> classInfoStuff = new ArrayList<String>();
		
		int startHourValue=0, startMinuteValue=0;
		int endHourValue=0, endMinuteValue=0;
		
		String cellValue = null;
		HSSFRow row = null; 
		
		//System.out.println("Hi in top of getRowWithTime hourString is: " + hour + ",  minuteString is: " + minute);
		
		//Ok, now we open the worksheet for the correct Day..   
		
		
		int hourWeAreLookingFor = Integer.parseInt(whatHour);
		int minuteWeAreLookingFor = Integer.parseInt(whatMinute);
		
		//System.out.println("Hi in getRowWithTime, hourWeAreLookingFor " + hourWeAreLookingFor + " minuteWeAreLookingFor " + minuteWeAreLookingFor);
		int rowWithTime = -1;
		
	
		int totalRows = worksheet.getLastRowNum();
		
		//System.out.println("In Get Rows, the totalRows for the Worksheet is " + totalRows);
		//Row 0 is a Title of the sheet 
		//Row 1 is header information
		int counter = 2;
		boolean done = false;
		
		
		
		while (!done){
			
				//System.out.println("In loop getting row, counter is " + counter);
				 row = worksheet.getRow(counter);
				
					
				try{
					HSSFCell cellStartHour = row.getCell(0);
					HSSFCell cellStartMinute = row.getCell(1);
					HSSFCell cellEndHour = row.getCell(2);
					HSSFCell cellEndMinute = row.getCell(3);
					
					startHourValue =  (int)cellStartHour.getNumericCellValue();
					startMinuteValue = (int)cellStartMinute.getNumericCellValue();
					endHourValue = (int)cellEndHour.getNumericCellValue();
					endMinuteValue = (int)cellEndMinute.getNumericCellValue();
					
					
					//System.out.println("Class is from " + startHourValue + ":" + startMinuteValue + " to "
					//+ endHourValue + ":" + endMinuteValue);
					
					
					
				} catch (Exception e){
					System.out.println("Couldn't open cell " + counter);
					
				}
				
				//end loop stuff
				//First see if you have the time
				
				/*System.out.println("At the Check checking Start: " + startHourValue + ":" + startMinuteValue +
						" against " + hourWeAreLookingFor + ":" + minuteWeAreLookingFor + " and " +
						endHourValue + ":" + endMinuteValue);
				*/
				
				int startTimeInMinutes = startHourValue*60 + startMinuteValue;
				int timeWeSeekInMinutes = hourWeAreLookingFor*60 + minuteWeAreLookingFor;
				int endTimeInMinutes = endHourValue*60 + endMinuteValue;
				
				//The NEW TEST
				if(startTimeInMinutes <= timeWeSeekInMinutes && timeWeSeekInMinutes <= endTimeInMinutes){
				
						
					/*	System.out.println("THERE IS A MATCH WERE START IS " + startHourValue + ":" + startMinuteValue +
								" Time to check is " + hourWeAreLookingFor + ":" + minuteWeAreLookingFor + " and END is " +
								endHourValue + ":" + endMinuteValue);
					*/
					
						HSSFCell periodInfo = row.getCell(4);
						HSSFCell periodColor= row.getCell(5);
						classInfoStuff.add(periodInfo.getRichStringCellValue().getString());
						classInfoStuff.add(periodColor.getRichStringCellValue().getString());
						rowWithTime=counter;
						done=true;
					}
				//}
				//Then see if you are out of rows to look at	
				if (counter < totalRows ){
					counter++;
				} else {
					done = true;
				}
			} //end of while
				
			
		if(rowWithTime <0 ){
			classInfoStuff.add("Error from GetClassInfo in finding the class");
			classInfoStuff.add("None");
		}
		
		
		return classInfoStuff;
	}
	
	public void openTheCorrectWorkSheet(String whatDay){
		
		
		
		try{
			worksheet = workbook.getSheet(whatDay);
			
			//System.out.println("we got the worksheet for " + weekDay);		
			
		
		}  catch (Exception e){

			System.out.println("Error  In getWorksheet -- Error in opening up the worksheet****");

		}

		
	}
}

