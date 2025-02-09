package Utilities;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public  class ExcelHandler {
	
	public static Map<String, String> getexceldata(String Sheetname,String Testcaseid,String Testdatafile)   {
		Fillo filo= new Fillo();
		Map<String,String> hm= new TreeMap<String,String>();
		String query=null;
		
		query=String.format("SELECT * FROM %s WHERE Run='Yes' and TCName='%s'", Sheetname , Testcaseid);
		Connection conn=null;
		Recordset recordset=null;
		try {

			conn=filo.getConnection(System.getProperty("user.dir")+Testdatafile);
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			recordset=conn.executeQuery(query);
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(recordset.next()) {
				for(String field:recordset.getFieldNames()) {
					hm.put(field,recordset.getField(field));
				}
				
				
			}
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conn.close();
		return hm;
		}
	

}
