package com.ur.urcap.api.contribution;

import com.ur.urcap.api.domain.script.ScriptWriter;

public class ToolbarInstalationNodeContribution implements InstallationNodeContribution {

	public ScriptWriter wrter ;
	@Override
	public void openView() {
		
		
	}

	@Override
	public void closeView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateScript(ScriptWriter writer) {
		writer.appendLine("global hbbtest_bar = "+111+"");
		//writer.appendLine("global hbb2_air = "+getAir()+"");
				
	}
	
	public void getScript() {
		generateScript(wrter);
	}
	
	public void checkInstal() {
		
	System.out.println("------Test ToolBarInst-----");
	}

}
