/**
 * 
 */
package com.amc.raagmala.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Amitava Chakraborty
 *
 */
public class CloseButton extends JButton
{

	public CloseButton()
	{
		super(new ImageIcon("resources\\close.jpg"));
	}

	public int getIconWidth() {
		return 17;
	}
	public int getIconHeight() {
	  return 17;
	}
	
}
