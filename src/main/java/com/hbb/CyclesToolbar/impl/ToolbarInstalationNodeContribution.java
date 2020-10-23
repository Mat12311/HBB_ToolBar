package com.hbb.CyclesToolbar.impl;


import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;
import com.hbb.CyclesToolbar.impl.CyclesToolbarContribution;


public class ToolbarInstalationNodeContribution implements InstallationNodeContribution {

	
	private final InstallationAPIProvider apiProvider;
	private final ToolbarInstalationNodeView view;
	private CyclesToolbarContribution tool;
	private final DataModel model;
	
	
	public int airT=0;
	public int pickT=0;
	public int chchT=0;
	
	private static final String AIR_KEY = "air";
	private static final int DEFAULT_AIR = 0;
	private static final String PICK_KEY = "pick";
	private static final int DEFAULT_PICK = 0;
	private static final String CHCH_KEY = "chch";
	private static final int DEFAULT_CHCH = 0;
	
	public ToolbarInstalationNodeContribution(InstallationAPIProvider apiProvider,
			ToolbarInstalationNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model=model;
		
	}
	
	public void onAirValueChange(final int val) {
		
				model.set(AIR_KEY,val);
	}
	
	public int getAir() {
		return model.get(AIR_KEY,DEFAULT_AIR);
	}
	
	public void onPickValueChange(final int val) {
	
				model.set(PICK_KEY,val);
				
		
	}
	
	public int getPICK() {
		return model.get(PICK_KEY,DEFAULT_PICK);
	}
	
	public void onCHCHValueChange(final int val) {
	
				model.set(CHCH_KEY,val);
				
	}
	
	public int getCHCH() {
		return model.get(CHCH_KEY,DEFAULT_CHCH);
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
	
		writer.appendLine("global cpl_airT = "+getAir()+"");
		
		writer.appendLine("global cpl_pickT = "+getPICK()+"");
		writer.appendLine("global cpl_chchT = "+getCHCH()+"");
		
				
	}
	
	
	
	public void checkInstal(int a, int b, int c) {
		airT= a;
		pickT= b;
		chchT= c;
	System.out.println("------Test ToolBarInst-----");

	
	}

}
