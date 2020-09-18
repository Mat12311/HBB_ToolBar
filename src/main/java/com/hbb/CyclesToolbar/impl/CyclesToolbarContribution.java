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


import com.ur.urcap.api.contribution.toolbar.ToolbarContext;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarContribution;

public class CyclesToolbarContribution implements SwingToolbarContribution {
	
	private JLabel airTextLabel = new JLabel("0");
	private JLabel pickTextLabel = new JLabel("0");
	private JLabel chchTextLabel = new JLabel("0");
	
	private JSlider airSlider = new JSlider();
	private JSlider pickSlider = new JSlider();
	private JSlider chchSlider = new JSlider();
	
	private final ToolbarContext context;
	
	CyclesToolbarContribution(ToolbarContext context) {
		this.context = context;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeView() {
		// TODO Auto-generated method stub
		
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
				/*
				if(label==airTextLabel) {
					contribution.onAirValueChange(txt);
					if(txt>5) txt=5;
				}
				if(label==pickTextLabel)contribution.onPickValueChange(txt);
				if(label==chchTextLabel)contribution.onCHCHValueChange(txt);
				*/
				slider.setValue(txt);
				label.setText(String.valueOf(txt));
				
				
				
			}
		});
		
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int txt= Integer.parseInt(label.getText());
				txt--;
				/*
				if(txt<0) txt=0;
				slider.setValue(txt);
				contribution.onAirValueChange(txt);
				if(label==pickTextLabel)contribution.onPickValueChange(txt);
				if(label==chchTextLabel)contribution.onCHCHValueChange(txt);
				*/
				label.setText(String.valueOf(txt));
				
				
				
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
				/*
				if(label==airTextLabel)contribution.onAirValueChange(newValue);
				if(label==pickTextLabel)contribution.onPickValueChange(newValue);
				if(label==chchTextLabel)contribution.onCHCHValueChange(newValue);
				*/
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
