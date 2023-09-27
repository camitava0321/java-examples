<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl" >
<xsl:template match="/">  
<html>
    <title> Sample Prototype using XML and XSL</title>
    <br> </br>
    <xsl:for-each select="resume">
       <b> Name  : <xsl:value-of select="name"/> </b> <br> </br>
       <b> Email :</b> <i><xsl:value-of select="email"/></i><br> </br>
       <b> Address :</b> 
       <br></br><i><xsl:value-of select="address/street"/></i>
       <br></br><i><xsl:value-of select="address/area"/></i>
       <br></br><i><xsl:value-of select="address/city"/></i>
       <br></br><i><xsl:value-of select="address/pin"/></i>
       <br></br>
       <b> Summary</b>
       <hr></hr>
       <xsl:value-of select="summ"/>
       <br></br>
    </xsl:for-each>
    
    <h3>Educational Background</h3>
    <hr></hr>
    <table >
      <tr bgcolor="#5555ff"> 
           <td width="30%"> <b>Degree</b> </td>
           <td width="20%"> <b>College/University</b> </td>
           <td width="30%"> <b>Year of Passing</b> </td>
      </tr> 
      <xsl:for-each select="resume/qual/degree">
           <tr>
              <td> <xsl:value-of select="@id"/> </td>
              <td> <xsl:value-of select="@inst"/> </td>
              <td> <xsl:value-of select="@yr"/> </td>
           </tr>
     </xsl:for-each>
    </table>
    <hr></hr>
    <h3>Skill Summary</h3>
    <hr></hr>
      <table >
       <tr bgcolor="#5555ff"> 
        <td width="25%"> <b>Category </b> </td>
        <td width="25%"> <b>Environment</b> </td>
        <td width="50%"> <b>Details </b></td>
      </tr>
       <xsl:for-each select="resume/skills/skill">
       <tr>
        <td> <xsl:value-of select="@cat"/></td>
        <td> <xsl:value-of select="@env1"/></td>
        <td> <xsl:value-of select="@elem1"/></td>
       </tr>
       <tr>
        <td> </td>
        <td> <xsl:value-of select="@env2"/></td>
        <td> <xsl:value-of select="@elem2"/></td>
       </tr>
       </xsl:for-each>
</table>
<hr> </hr>
<h3>Project Profiles</h3>
<hr></hr>
<xsl:for-each select="resume/projects/project">
<table  width="100%">
<tr>  <td  colspan="2"><b><xsl:value-of select="title"/></b></td>  </tr>
<tr>  <td  colspan="2"><b><xsl:value-of select="dur"/> </b></td> </tr>
<tr>
  <td width="40%"> Client </td>
  <td width="600%"> <xsl:value-of select="client"/></td>
</tr>
<tr>
  <td width="40%"> Role </td>
  <td width="60%"> <xsl:value-of select="role"/></td>
</tr>
<tr>
  <td width="40%"> Project Location </td>
  <td width="60%"> <xsl:value-of select="loc"/></td>
</tr>
<tr>
  <td width="40%"> Hardware </td>
  <td width="60%"> <xsl:value-of select="hard"/></td>
</tr>
<tr>
  <td width="40%"> Operating System </td>
  <td width="60%"> <xsl:value-of select="os"/></td>
</tr>
<tr>
  <td width="40%"> Programming Language </td>
  <td width="60%"> <xsl:value-of select="lang"/></td>
</tr>
<tr>
  <td width="40%"> Database and Tools </td>
  <td width="60%"> <xsl:value-of select="others"/></td>
</tr>
<tr> </tr>
<tr>
  
  <td colspan="2" align="left"> <xsl:value-of select="desc"/></td>
</tr>
<tr> </tr>
<tr>
  
  <td colspan="2" align="left"> <xsl:value-of select="indv"/></td>
</tr>
</table>
<hr> </hr>
</xsl:for-each>
</html>
</xsl:template>
</xsl:stylesheet>