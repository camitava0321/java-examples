<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">
  <xsl:template match="/">
    <HTML>
    <head><title>Error Messages</title></head>
      <BODY>
        <TABLE  border="1" cellspacing="15" cellpadding="15">
	<xsl:for-each select="errors/error">
	<TR bgcolor="#ffffff">
	<xsl:attribute name="STYLE">color:
                <xsl:choose>
                  <xsl:when test="category[.='ERROR']">red</xsl:when>
                  <xsl:when test="category[.='FATAL']">red</xsl:when>
                  <xsl:when test="category[.='WARNING']">green</xsl:when>
                  <xsl:otherwise>black</xsl:otherwise>
                </xsl:choose>
             </xsl:attribute>
                                          
            <TD>
			<img width="50" height="50" align="middle">
			<xsl:attribute name="src">
			<xsl:value-of select="icon"/>.bmp
		    </xsl:attribute>
		    </img>
		<xsl:value-of select="@errorid"/>: <xsl:value-of select="errortext"/>
		<p align="center">
		<form>
		<xsl:for-each select="action">
		<input type="button" style="background-color:#aaaaff;">
		<xsl:attribute name="value">
		<xsl:value-of select="actionname"/>
		</xsl:attribute>
		<xsl:attribute name="style">
		background-color:#aaaaff;border-color:
		<xsl:choose>
		<xsl:when test="actionid[.='1']">#8888ff</xsl:when>
		<xsl:otherwise>#000000</xsl:otherwise>
		</xsl:choose>
		</xsl:attribute>
		</input>
        </xsl:for-each>
		</form>
		</p>
	    </TD>
        </TR>
        </xsl:for-each>
        </TABLE>
       </BODY>
    </HTML>
  </xsl:template>
</xsl:stylesheet>