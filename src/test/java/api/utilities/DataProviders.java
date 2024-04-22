package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="AllData")
	public String [][] AllUserData(){
		
		String fName="C:\\Users\\DELL\\eclipse-workspace\\jkl\\TestData\\testData.xlsx";
		
		int TotalRowCount=ReadExcelFile2.getRowCount(fName, "Data");
		int TotalColumnCount=ReadExcelFile2.columnCount(fName, "Data");
		
		String data [][]=new String[TotalRowCount-1][TotalColumnCount];
		
		for(int i=1;i<TotalRowCount;i++) {
			
			for(int j=0;j<TotalColumnCount;j++) {
				
				 data[i-1][j]=ReadExcelFile2.getCellValue(fName, "Data", i, j);
			}
		}
		
		return data;
	}
	
	@DataProvider(name="UserNameData")
	public String [] UserNamesData(){
		
		String fName="C:\\Users\\DELL\\eclipse-workspace\\jkl\\TestData\\testData.xlsx";
		
		int TotalRowCount=ReadExcelFile2.getRowCount(fName, "Data");
		//int TotalColumnCount=ReadExcelFile2.columnCount(fName, "Data");
		
		String userNamedata []=new String[TotalRowCount];
		
		for(int i=1;i<=TotalRowCount;i++) {
			
			userNamedata[i-1]=ReadExcelFile2.getCellValue(fName, "Data", i, 1);
		}
		
		return userNamedata;
	}
	
	

}
