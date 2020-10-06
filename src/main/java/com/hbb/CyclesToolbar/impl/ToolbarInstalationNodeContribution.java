package com.hbb.CyclesToolbar.impl;


import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.hbb.CyclesToolbar.impl.CyclesToolbarContribution;


public class ToolbarInstalationNodeContribution implements InstallationNodeContribution {

	//public ScriptWriter wrter ;
	private final InstallationAPIProvider apiProvider;
	private final ToolbarInstalationNodeView view;
	private CyclesToolbarContribution tool;
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
		//writer.appendLine("global hbb3t_air = "+tool.getAir()+"");
		
				
	}
	
	
	
	public void checkInstal() {
		
	System.out.println("------Test ToolBarInst-----");
		//generateScript(ScriptWriter w);
	//System.console().writer().print(tool.getClass());;
	
	}

}
