package sapserver;

import com.sap.conn.jco.AbapClassException;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

public class HandlerZ_FM_STRUCTURE implements JCoServerFunctionHandler {
	//Implementation of SAP Function Module Code Source
	@Override
	public void handleRequest(JCoServerContext serverCtx, JCoFunction function)
			throws AbapException, AbapClassException {

		System.out.println("HandlerZ_FM_STRUCTURE called");
		
		//Get Import Parameter
		String carrier = function.getImportParameterList().getString("IV_CARRIER");
		if (carrier.contentEquals("UA")){
			System.out.println("Error EX_EMPTY");
			throw new AbapException("EX_EMPTY");
		}
		
		//Set Export Parameter	
		JCoStructure struct = function.getExportParameterList().getStructure("ES_EMPLOYEE") ;
		struct.setValue("FIRSTNAME", "Pierre");
		struct.setValue("LASTNAME", "Anken");
	}
}