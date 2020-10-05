package com.ur.urcap.api.contribution;


import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;

public class ToolbarInstalationNodeContribution implements InstallationNodeContribution {

	public ScriptWriter wrter ;
	private final InstallationAPIProvider apiProvider;
	private final ToolbarInstalationNodeView view;
	private final DataModel model;
	
	public ToolbarInstalationNodeContribution(InstallationAPIProvider apiProvider,
			ToolbarInstalationNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model=model;
	}
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
