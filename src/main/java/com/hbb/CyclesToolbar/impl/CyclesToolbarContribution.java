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
	
	private JLabel airTextLabel = new JLabel("0");
	private JLabel pickTextLabel = new JLabel("0");
	private JLabel chchTextLabel = new JLabel("0");
	
	private JSlider airSlider = new JSlider();
	private JSlider pickSlider = new JSlider();
	private JSlider chchSlider = new JSlider();
	
	public int air=0;
	public int pick=0;
	public int chch=0;
	
	private final ToolbarContext context;
	private ToolbarAPIProvider api ;
	
	CyclesToolbarContribution(ToolbarContext context) {
		this.context = context;
		this.api = context.getAPIProvider();
	}
	


	@Override
	public void buildUI(JPanel panel) {
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		panel.add(createDescrption("AIR"));
		//panel.add(createSpacer(5));
		panel.add(createTextLabelButton(airTextLabel,airSlider));
		panel.add(createSpacer(5));
		panel.add(createSlider(airSlider, 0, 5, airTextLabel));
		panel.add(createSpacer(5));
		panel.add(createDescrption("PICK"));
		//panel.add(createSpacer(5));
		panel.add(createTextLabelButton(pickTextLabel, pickSlider));
		panel.add(createSpacer(5));
		panel.add(createSlider(pickSlider, 0, 20, pickTextLabel));
		panel.add(createSpacer(5));
		panel.add(createDescrption("CHCH"));
		//panel.add(createSpacer(5));
		panel.add(createTextLabelButton(chchTextLabel, chchSlider));
		panel.add(createSpacer(5));
		panel.add(createSlider(chchSlider, 0, 50, chchTextLabel));
		
	}

	@Override
	public void openView() {
	
		getInstallation().checkInstal(air, pick,chch);
		
	
		
	}

	@Override
	public void closeView() {
		// TODO Auto-generated method stub
		
	}
	
	private ToolbarInstalationNodeContribution getInstallation() {
		return api.getApplicationAPI().getInstallationNode(ToolbarInstalationNodeContribution.class);
	}
	
	private Box createDescrption(String desc) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel label = new JLabel(desc);
		label.setPreferredSize(new Dimension(60,30));
		label.setMaximumSize(label.getPreferredSize());
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		box.add(label);
		return box;

}
	private Box createTextLabelButton(final JLabel label, final JSlider slider
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
					air =txt;
					if(txt>5) txt=5;
				}
				if(label==pickTextLabel) {
					pick=txt;
					if(txt>20) txt=20;
				}
				
				if(label==chchTextLabel) {
					chch=txt;
					if(txt>50) txt=50;
				}
				
				slider.setValue(txt);
				label.setText(String.valueOf(txt));
				
				getInstallation().checkInstal(air,pick,chch);
				
			}
		});
		
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int txt= Integer.parseInt(label.getText());
				txt--;
				
				if(txt<0) txt=0;
				slider.setValue(txt);
				if(label==airTextLabel)air=txt;
				if(label==pickTextLabel)pick= txt;
				if(label==chchTextLabel)chch=txt;
				
				label.setText(String.valueOf(txt));
				
				getInstallation().checkInstal(air,pick,chch);
				
			}
		});
		
		
		
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
				
				if(label==airTextLabel)air= newValue;
				if(label==pickTextLabel)pick=newValue;
				if(label==chchTextLabel)chch=newValue;
				
				label.setText(String.valueOf(newValue));
				getInstallation().checkInstal(air,pick,chch);
				
				
			}
		});
	
		box.add(slider);
		
		return box;
	}
	private Component createSpacer(int height) {
		return Box.createRigidArea(new Dimension(0,height));
	}
	
	

}
