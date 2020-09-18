package com.hbb.CyclesToolbar.impl;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.ur.urcap.api.contribution.toolbar.ToolbarConfiguration;
import com.ur.urcap.api.contribution.toolbar.ToolbarContext;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarContribution;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarService;

public class CyclesToolbarService implements SwingToolbarService {

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource("/icons/logo.png"));
	}

	@Override
	public void configureContribution(ToolbarConfiguration configuration) {
		configuration.setToolbarHeight(250);
		
	}

	@Override
	public SwingToolbarContribution createToolbar(ToolbarContext context) {
		return new CyclesToolbarContribution(context);
	}

}
