package sapserver;

import com.sap.conn.jco.AbapClassException;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

public class HandlerSTFC_CONNECTION implements JCoServerFunctionHandler{

	@Override
	public void handleRequest(JCoServerContext serverCtx, JCoFunction function)
			throws AbapException, AbapClassException {

		System.out.println("HandlerSTFC_CONNECTION called");
		
		//Get Import Parameter
		String txt = function.getImportParameterList().getString("REQUTEXT");
		
		//Implementation
		String resptxt = "JCo RFC Server - " + txt ;
		
		//Set Export Parameter
		function.getExportParameterList().setValue("ECHOTEXT", txt);
		function.getExportParameterList().setValue("RESPTEXT", resptxt);
	}

}
