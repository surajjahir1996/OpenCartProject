package utilityPackage;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
//  we have to create a method for data pro
	
	@DataProvider(name="LoginData")  // give the dataprovider name
	public String [][] getData() throws IOException
	{
	   String path="./testData/Opencart_LoginData2.xlsx"; // taking xl file from testData folder
	   
	   ExcelUtility xlutil= new ExcelUtility(path); // creating object for xlutility
	   
	   int totalrows=xlutil.getRowCount("Sheet1");
	   int totalcolu=xlutil.getCellCount("Sheet1",1);  // sheet name and rowNum is 1
	   
//	   create two dimensional array for storing the data username and pass
	   String LoginData[][]= new String [totalrows][totalcolu];
	   
//	   now create the for loop for read the data from xl and storing into two dimensional array
	   
	   for(int i=1; i<=totalrows; i++) // i is rows avoid heading of xl file is 1 
	   {
		   for(int j=0; j<totalcolu; j++) // j is colu is 0
		   {
			LoginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);    
		   }
		   
	   }
			   
		return LoginData; // return to two dimensional array
		// method complete.
	}
	
	
	
	

}
