package util;

import sapconnector.SAPDestination;

public class Launch{
	
	public static void main(String[] args)
	{
		SAPDestination server = new SAPDestination("D20");
		//Call Methods
		server.testRFCConnection("SAP") ;
		System.out.println();
		server.divide(10, 2) ;
		server.divide(10, 0) ; //Division by zero
		System.out.println();
		server.displayEmployee("AA", 1) ;
		server.displayEmployee("AA", 10) ; //Empty selection
		System.out.println();
		server.displayEmployees("SR") ;
		server.displayEmployees("AF") ; //Empty selection
	}

}
