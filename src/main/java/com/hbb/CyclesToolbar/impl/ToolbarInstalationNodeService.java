package com.hbb.CyclesToolbar.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.installation.ContributionConfiguration;
import com.ur.urcap.api.contribution.installation.CreationContext;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.domain.data.DataModel;
import com.hbb.CyclesToolbar.impl.ToolbarInstalationNodeContribution;

public class ToolbarInstalationNodeService implements SwingInstallationNodeService<ToolbarInstalationNodeContribution, ToolbarInstalationNodeView> {

	@Override
	public void configureContribution(ContributionConfiguration configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitle(Locale locale) {
	
		return "ToolbarInst";
	}

	@Override
	public ToolbarInstalationNodeView createView(ViewAPIProvider apiProvider) {
		
		return new ToolbarInstalationNodeView(apiProvider);
	}

	@Override
	public ToolbarInstalationNodeContribution createInstallationNode(InstallationAPIProvider apiProvider,
			ToolbarInstalationNodeView view, DataModel model, CreationContext context) {
		
		return new ToolbarInstalationNodeContribution(apiProvider, view, model) ;
	}

}
