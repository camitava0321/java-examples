package com.amc.demo.beans;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class MyFirstBean extends Canvas implements Serializable
{
private Color color = Color.green;

    public MyFirstBean()
    {
        setSize(60,40);
        setBackground(Color.red);
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color newColor)
    {
        color = newColor;
        repaint();
    }

    public void paint(Graphics g)
    {
        g.setColor(color);
        g.fillRect(20,5,20,30);
    }
}
