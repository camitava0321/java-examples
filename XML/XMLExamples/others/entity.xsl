<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">
  <xsl:template match="/">
    <HTML>
      <BODY>
      <h1>Clients</h1>
          <xsl:for-each select="clients/client">
          	<h3><xsl:value-of select="name"/></h3>
          	<p>
			<b>Address: </b><xsl:value-of select="address"/><br/>
          	<b>Phone: </b><xsl:value-of select="phone"/>
          	</p>
          </xsl:for-each>
      </BODY>
    </HTML>
  </xsl:template>
</xsl:stylesheet>
