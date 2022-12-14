package org.testngkeyword.com;

import java.lang.reflect.Method;
import java.util.List;



public class driverexec {

	
	@org.testng.annotations.Test
	public void mainmethod ()throws Exception {
		DatatableExcel data= new DatatableExcel("input.xlsx");
		data.createconnection();
		
		List<String> methodstoExecute = data.getAllMethods();
		drivermethods dm=new drivermethods();
		
		Method[] method=dm.getClass().getDeclaredMethods();
		
		for(String s:methodstoExecute)
		{
			for(Method m: method)
			{
				if(m.getName().equals(s))
				{
					m.invoke(dm);
				}
			}
		}
		

	}

}
