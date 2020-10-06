package com.hbb.CyclesToolbar.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.hbb.CyclesToolbar.impl.CyclesToolbarService;
import com.hbb.CyclesToolbar.impl.ToolbarInstalationNodeService;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarService;

/**
 * Hello world activator for the OSGi bundle URCAPS contribution
 *
 */
public class Activator implements BundleActivator {
	@Override
	public void start(final BundleContext bundleContext) throws Exception {
		System.out.println("Activator says Hello World!");
		bundleContext.registerService(SwingToolbarService.class, new CyclesToolbarService(), null);
		bundleContext.registerService(SwingInstallationNodeService.class, new ToolbarInstalationNodeService(), null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Activator says Goodbye World!");
	}
}

