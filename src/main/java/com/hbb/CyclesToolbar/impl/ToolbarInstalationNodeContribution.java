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
	
	
	private static final String AIR_KEY = "air";
	private static final int DEFAULT_AIR = 2;
	private static final String PICK_KEY = "pick";
	private static final int DEFAULT_PICK = 5;
	private static final String CHCH_KEY = "chch";
	private static final int DEFAULT_CHCH = 10;
	private  String seria = "20195000394";
	//private  String seria = "20195599999";
	
	public ToolbarInstalationNodeContribution(InstallationAPIProvider apiProvider,
			ToolbarInstalationNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model=model;
		
	}
	
	public String getSeria() {
		String seria = apiProvider.getSystemAPI().getRobotModel().getSerialNumber();
		System.out.println("SERIA"+seria);
		return seria;
	}
	
	public void onAirValueChange(int val) {
		System.out.println("AIR Change"+val);
				model.set(AIR_KEY,val);
	}
	
	public int getAir() {
		int val= model.get(AIR_KEY,DEFAULT_AIR);
		System.out.println("AIR Get"+val);
		return val;
	}
	
	public void onPickValueChange(int val) {
		System.out.println("Pick Change"+val);
				model.set(PICK_KEY,val);
				
		
	}
	
	public int getPICK() {
		int val = model.get(PICK_KEY,DEFAULT_PICK);
		System.out.println("Pick Get"+val);
		return val;
	}
	
	public void onCHCHValueChange(int val) {
		System.out.println("CHCH Change"+val);
				model.set(CHCH_KEY,val);
				
	}
	
	public int getCHCH() {
		int val= model.get(CHCH_KEY,DEFAULT_CHCH);
		System.out.println("chch Get"+val);
		return val;
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
	
//		writer.appendLine("global cpl_airT = "+getAir()+"");
//		
//		writer.appendLine("global cpl_pickT = "+getPICK()+"");
//		writer.appendLine("global cpl_chchT = "+getCHCH()+"");
		
		//writer.appendLine("global seria = "+getSeria()+"");
		if(0!=getSeria().compareTo(seria)) {
			writer.appendLine("global cpl_airT = False");
			
			writer.appendLine("global cpl_pickT = False");
			writer.appendLine("global cpl_chchT = False");
			//writer.appendLine("popup('Seria ERROR',title='ERROR',blocking=True)");
			writer.appendLine("powerdown()");
			
			
		}else {
			writer.appendLine("global cpl_airT = "+getAir()+"");
			
			writer.appendLine("global cpl_pickT = "+getPICK()+"");
			writer.appendLine("global cpl_chchT = "+getCHCH()+"");
			
		}
		
				
	}
	

}
