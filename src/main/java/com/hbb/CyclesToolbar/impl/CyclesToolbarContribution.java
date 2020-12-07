package com.hbb.CyclesToolbar.impl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import com.ur.urcap.api.contribution.toolbar.ToolbarAPIProvider;
import com.ur.urcap.api.contribution.toolbar.ToolbarContext;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarContribution;


public class CyclesToolbarContribution implements SwingToolbarContribution {
	
	private JLabel airTextLabel = new JLabel();
	private JLabel pickTextLabel = new JLabel();
	private JLabel chchTextLabel = new JLabel();
	
	private JSlider airSlider = new JSlider();
	private JSlider pickSlider = new JSlider();
	private JSlider chchSlider = new JSlider();
	private  String seria = "20195000394";
	//private  String seria = "20195599999";
	private int P =0;
	

	
	private final ToolbarContext context;
	private ToolbarAPIProvider api ;
	
	CyclesToolbarContribution(ToolbarContext context) {
		this.context = context;
		this.api = context.getAPIProvider();
	}
	


	@Override
	public void buildUI(JPanel panel) {
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		System.out.println(seria);
		System.out.println("TEST");
		System.out.println(0==getInstallation().getSeria().compareTo(seria));
		
		if(0!=getInstallation().getSeria().compareTo(seria)) {
			P=1;
			Disable();
			
			panel.add(createDescrption("SERIA ERROR"));
			
			
		}
		
		
		panel.add(createDescrption("AIR"));
		//panel.add(createSpacer(5));
		panel.add(createTextLabelButton(airTextLabel,airSlider,P));
		panel.add(createSpacer(5));
		panel.add(createSlider(airSlider, 0, 5, airTextLabel));
		panel.add(createSpacer(5));
		panel.add(createDescrption("PICK"));
		//panel.add(createSpacer(5));
		panel.add(createTextLabelButton(pickTextLabel, pickSlider,P));
		panel.add(createSpacer(5));
		panel.add(createSlider(pickSlider, 0, 20, pickTextLabel));
		panel.add(createSpacer(5));
		panel.add(createDescrption("CHCH"));
		//panel.add(createSpacer(5));
		panel.add(createTextLabelButton(chchTextLabel, chchSlider,P));
		panel.add(createSpacer(5));
		panel.add(createSlider(chchSlider, 0, 50, chchTextLabel));
		
	
	}

	@Override
	public void openView() {
		
		if(0==getInstallation().getSeria().compareTo(seria)) {
	
	
		airTextLabel.setText(String.valueOf( getInstallation().getAir()));
		pickTextLabel.setText(String.valueOf( getInstallation().getPICK()));
		chchTextLabel.setText(String.valueOf( getInstallation().getCHCH()));
		
		airSlider.setValue(getInstallation().getAir());
		pickSlider.setValue(getInstallation().getPICK());
		chchSlider.setValue(getInstallation().getCHCH());
		}
		else {
			
			
			
			airTextLabel.setText("E");
			pickTextLabel.setText("E");
			chchTextLabel.setText("E");
			
			airSlider.setValue(0);
			pickSlider.setValue(0);
			chchSlider.setValue(0);
			
		}
		
		
	}

	@Override
	public void closeView() {
		

			
	}
	
	private ToolbarInstalationNodeContribution getInstallation() {
		return api.getApplicationAPI().getInstallationNode(ToolbarInstalationNodeContribution.class);
	}
	
	private void Disable() {
		airSlider.enable(false);
		airTextLabel.enable(false);
		
		pickSlider.setEnabled(false);
		pickTextLabel.setEnabled(false);
		
		chchSlider.setEnabled(false);
		chchTextLabel.setEnabled(false);
		
		
	}
	
	private Box createDescrption(String desc) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel label = new JLabel(desc);
		label.setPreferredSize(new Dimension(160,30));
		label.setMaximumSize(label.getPreferredSize());
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		box.add(label);
		return box;

}
	private Box createTextLabelButton(final JLabel label, final JSlider slider, final int P
			) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton plus = new JButton("+");
		plus.setPreferredSize(new Dimension(10,10));
		plus.setMinimumSize(plus.getPreferredSize());
		JButton minus = new JButton("-");
		minus.setPreferredSize(new Dimension(10,10));
		minus.setMinimumSize(plus.getPreferredSize());
		
		label.setPreferredSize(new Dimension(30,40));
		label.setMaximumSize(label.getPreferredSize());
		label.setFont(label.getFont().deriveFont(Font.BOLD));

		
		
		
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int txt= Integer.parseInt(label.getText());
				txt++;
				
				if(label==airTextLabel) {
					
					getInstallation().onAirValueChange(txt);
					if(txt>5) txt=5;
				}
				if(label==pickTextLabel) {
					
					getInstallation().onPickValueChange(txt);
					if(txt>20) txt=20;
				}
				
				if(label==chchTextLabel) {
					
					getInstallation().onCHCHValueChange(txt);
					if(txt>50) txt=50;
				}
				
				slider.setValue(txt);
				label.setText(String.valueOf(txt));
				
				
				
			}
		});
		
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int txt= Integer.parseInt(label.getText());
				txt--;
				
				if(txt<0) txt=0;
				
				if(label==airTextLabel) {
					
					getInstallation().onAirValueChange(txt);
				
				}
				if(label==pickTextLabel) {
					
					getInstallation().onPickValueChange(txt);
				}
				if(label==chchTextLabel) {
					
					getInstallation().onCHCHValueChange(txt);
				}
				
				label.setText(String.valueOf(txt));
				slider.setValue(txt);
			
				
			}
		});
		
		if(P==1) {
			minus.setEnabled(false);
			plus.setEnabled(false);
		}
		
		box.add(minus);
		box.add(label);
		box.add(plus);
		
		
		return box;
	}
	
	private Box createSlider(final JSlider slider, int min, int max, final JLabel label) {
		
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider.setMinimum(min);
		slider.setMaximum(max);
		slider.setValue(0);
		slider.setOrientation(JSlider.HORIZONTAL);
		
		slider.setPreferredSize(new Dimension(500,30));
		slider.setMaximumSize(slider.getPreferredSize());
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int newValue = slider.getValue();
				
				if(label==airTextLabel) {
					
					getInstallation().onAirValueChange(newValue);
				}
				if(label==pickTextLabel) {
					
					getInstallation().onPickValueChange(newValue);
				}
				if(label==chchTextLabel) {
					
					getInstallation().onCHCHValueChange(newValue);
					}
				
				label.setText(String.valueOf(newValue));
				
				
				
			}
		});
	
		box.add(slider);
		
		return box;
	}
	private Component createSpacer(int height) {
		return Box.createRigidArea(new Dimension(0,height));
	}
	
	

}
