package com.ur.urcap.api.contribution;

import javax.swing.JPanel;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeView;

public class ToolbarInstalationNodeView implements SwingInstallationNodeView<ToolbarInstalationNodeContribution> {

	
	ViewAPIProvider apiProvider;
	
	 public  ToolbarInstalationNodeView(ViewAPIProvider apiProvider) {
		this.apiProvider=apiProvider;
	}
	 
	
	
	@Override
	public void buildUI(JPanel panel, ToolbarInstalationNodeContribution contribution) {
		// TODO Auto-generated method stub
		
	}

}
