package com.amc.raagmala.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import com.amc.raagmala.exception.RaagDataException;
import com.amc.raagmala.vo.Raag;

public class RaagPanel extends JPanel implements Serializable
{
public static final String REFERENCE_TEXT=
  "SWAR    SUDDHA     KOMAL\n"+
  "Shadaj   S\n"+
  "Rishav   R           r\n"+
  "Gandhar  G           g\n"+
  "Madhyam  m                    (Tivra)M\n"+
  "Pancham  P\n"+
  "Dhaibat  D           d\n"+
  "Nishad   N           n\n"+
  "";
EtchedBorder border = new EtchedBorder(EtchedBorder.RAISED);

      private JEditorPane txtDetails = new JEditorPane("text/html","");
      private JScrollPane scrollPane = new JScrollPane(txtDetails);
      private JTextArea txtReference = new JTextArea();
      private JScrollPane scrollRef = new JScrollPane(txtReference);

      private Color padColor=new Color(210,230,250);

  public RaagPanel() throws RaagDataException
  {
    txtDetails.setBorder(BorderFactory.createCompoundBorder(
                      BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                      BorderFactory.createEmptyBorder(5,5,5,5)));


    txtDetails.setEditable(false);
    txtDetails.setFont(new Font("Tahoma",Font.PLAIN,14));
//    txtDetails.setLineWrap(true);
//    txtDetails.setWrapStyleWord(true);
    txtDetails.setCaretPosition(0);
    txtDetails.setMargin(new Insets(2,5,5,2));
//    txtDetails.setBorder(border);

    txtReference.setEditable(false);
    txtReference.setFont(new Font("Courier",Font.PLAIN,11));
    txtReference.setLineWrap(true);
    txtReference.setWrapStyleWord(true);
    txtReference.setCaretPosition(0);
    txtReference.setMargin(new Insets(2,5,5,2));
    txtReference.setBorder(border);
    txtReference.setBackground(new Color(250,250,200));


    setLayout(new BorderLayout());

    add(scrollPane);
    add(scrollRef,BorderLayout.SOUTH);

    txtReference.setText(REFERENCE_TEXT);
    setPadColor(padColor);
  }

  public RaagPanel(Raag raag) throws RaagDataException
  {
    this();
    displayRaagDetails(raag);
  }

  public void displayRaagDetails(Raag raag)
  {
  String printString="<html><body>";
    if(raag!=null)
      {
      printString=printString+
        "<h1>"+raag.toString()+"</h1>"+
        "<p>Jati : "+raag.getJatiDescription()+
        "<br>Vadi : "+raag.getVadi()+
        "&nbsp;&nbsp;&nbsp;Samvadi : "+raag.getSamvadi()+
        "<p>Aroha : "+raag.getAroha()+
        "<br>Aboroha : "+raag.getAboroha()+
        "<p>Pakad : "+raag.getPakad()+
        "<br>Chalan : "+raag.getChalan()+
        "<p>Ras : "+raag.getRas()+
        "<br>Prokriti : "+raag.getProkriti()+
        "<p>Time : "+raag.getTime()+
        "<p>Remarks : "+raag.getRemarks()+
        "</body></html>";

      txtDetails.setText(printString);
      }
  }

  public Color getPadColor()
  {
  return(padColor);
  }

  public void setPadColor(Color c)
  {
  padColor=c;
  txtDetails.setBackground(padColor);
  }

}
