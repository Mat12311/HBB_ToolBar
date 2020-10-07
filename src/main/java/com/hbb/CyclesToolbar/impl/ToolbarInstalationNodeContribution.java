package com.hbb.CyclesToolbar.impl;


import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.hbb.CyclesToolbar.impl.CyclesToolbarContribution;


public class ToolbarInstalationNodeContribution implements InstallationNodeContribution {

	
	private final InstallationAPIProvider apiProvider;
	private final ToolbarInstalationNodeView view;
	private CyclesToolbarContribution tool;
	private final DataModel model;
	private int airT=666;
	private int pickT=666;
	private int chchT=666;
	
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
		writer.appendLine("global hbb3t_air = "+airT+"");
		writer.appendLine("global hbb3t_pick = "+pickT+"");
		writer.appendLine("global hbb3t_chch = "+chchT+"");
		
				
	}
	
	
	
	public void checkInstal(int a, int b, int c) {
		airT= a;
		pickT= b;
		chchT= c;
	System.out.println("------Test ToolBarInst-----");

	
	}

}
