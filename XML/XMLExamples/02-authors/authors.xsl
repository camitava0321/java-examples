<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">
  <xsl:template match="/">
    <HTML>
      <BODY>
        <TABLE BORDER="2">
          <TR>
	           
            <TD>Name</TD>
            <TD>Nationality</TD>
	    <TD>Book Price</TD>	
          </TR>
	<xsl:for-each select="authors/author">
	<TR>
	<xsl:attribute name="STYLE">color:
                <xsl:choose>
                  <xsl:when test="bprice[. $le$ 300]">green</xsl:when>
                  <xsl:when test="bprice[. $le$ 500]">blue</xsl:when>
                  <xsl:otherwise>red</xsl:otherwise>
                </xsl:choose>
             </xsl:attribute>
                                          
            <TD>
		<xsl:if test="@period[.='classical']"><xsl:value-of select="name"/></xsl:if>
	    </TD>
             <TD>
		<xsl:if test="@period[.='classical']"><xsl:value-of select="nationality"/></xsl:if>
	    </TD>
            <TD>
		<xsl:if test="@period[.='classical']"><xsl:value-of select="bprice"/></xsl:if>
	    </TD>
              		             
            </TR>
          </xsl:for-each>
        </TABLE>
       </BODY>
    </HTML>
  </xsl:template>
</xsl:stylesheet>
