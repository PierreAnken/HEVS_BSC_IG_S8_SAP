package sapserver;

import com.sap.conn.jco.AbapClassException;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

public class HandlerZ_FM_TABLE implements JCoServerFunctionHandler {
	//Implementation of SAP Function Module Code Source
	@Override
	public void handleRequest(JCoServerContext serverCtx, JCoFunction function)
			throws AbapException, AbapClassException {
		
		System.out.println("HandlerZ_FM_TABLE called");
		
		try {
			//Get Import Parameter
			String carrier = function.getImportParameterList().getString("IV_CARRIER");
			if (carrier.contentEquals("UA")){
				System.out.println("Error EX_EMPTY");
				throw new AbapException("EX_EMPTY");
			}
			
			//Set Export Parameter	
			JCoTable table = function.getExportParameterList().getTable("ET_EMPLOYEES") ;
			table.appendRow();
			table.setValue("FIRSTNAME", "Pierre");
			table.setValue("LASTNAME", "Anken");
			table.setValue("CARRIER", carrier);
			
			table.appendRow();
			table.setValue("FIRSTNAME", "Luc");
			table.setValue("LASTNAME", "Legrand");
			table.setValue("CARRIER", carrier);
			
		} catch (Exception e) {
			throw new AbapException("EX_ABAP");
		}
		
	}
}