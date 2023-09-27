<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">
  <xsl:template match="/">
    <HTML>
      <BODY>
        <TABLE BORDER="2">
          <tr>
          <th>code</th>
          <th>Manuf</th>
	  <th>Title</th>
	  <th>Occup</th>
	  <th>RivalCompany</th>
	  <th>RivalProduct</th>
	  <th>RateDate</th>
	  <th>ScriptDate</th>
	  <th>CurrentDate</th>
	  </tr>
	   <tr>
	    <td>
	   	           <xsl:for-each select="QuoteNewMOut/ReturnCode">
	   	                          
	   	                <xsl:value-of/> <br/>
	   	  	   
	   	            </xsl:for-each>
          </td>
    	 <td>
         <xsl:for-each select="QuoteNewMOut/ManufList/Manuf">
                        
              <xsl:value-of/> <br/>
	   
          </xsl:for-each>
          </td>
          
         
          
	 <td>
	   <xsl:for-each select="QuoteNewMOut/TitleList/Title">

		<xsl:value-of/> <br/>

	    </xsl:for-each>
	    </td>
          
	 <td>
	   <xsl:for-each select="QuoteNewMOut/OccupList/Occup">

		<xsl:value-of/> <br/>

	    </xsl:for-each>
	    </td>
	     <td>
	   <xsl:for-each select="QuoteNewMOut/RescueRivalList/RescueRival">

		<xsl:value-of select="RivalCompany"/>
		<br/>

	    </xsl:for-each>
	    </td>
	    <td>
	    	   <xsl:for-each select="QuoteNewMOut/RescueRivalList/RescueRival">
	    
	    		<xsl:value-of select="RivalProduct"/><br/>
	    
	    	    </xsl:for-each>
	    </td>
	    <td>
	   <xsl:for-each select="QuoteNewMOut/RateDate">

		<xsl:value-of select="RateDate"/>
		<xsl:value-of select="@Day"/>/<xsl:value-of select="@Month"/>/<xsl:value-of select="@Year"/>
	    </xsl:for-each>
	    </td>
	    <td>
	   <xsl:for-each select="QuoteNewMOut/RateDate">

		<xsl:value-of select="ScriptDate"/>
		<xsl:value-of select="@Day"/>/<xsl:value-of select="@Month"/>/<xsl:value-of select="@Year"/>
	    </xsl:for-each>
	    </td>
	    <td>
	    	   <xsl:for-each select="QuoteNewMOut/CurrentDate">
	    
	    		<xsl:value-of select="RateDate"/>
	    		<xsl:value-of select="@Day"/>/<xsl:value-of select="@Month"/>/<xsl:value-of select="@Year"/>
	    	    </xsl:for-each>
	    </td>
          </tr>
        </TABLE>
      </BODY>
    </HTML>
  </xsl:template>
</xsl:stylesheet>