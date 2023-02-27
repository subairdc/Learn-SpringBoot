<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">       
    
    <!-- Global Variable -->
    <xsl:variable name="Secondbook" select="/books/book[2]/bookName[1]"/>   
    
    <!-- Key -->
    <xsl:key name = "get-publisher" match = "book" use = "publisher"/>   
    <xsl:template match = "/">           
        <html>  
            <body>  
                <h2>Books:-</h2>   
                <table border = "1">   
                    <tr bgcolor = "#cd8932">   
                        <th>Book ID</th>   
                        <th>Book Name</th>   
                        <th>Author Name</th>   
                        <th>Publisher</th>   
                        <th>Price</th>                           
                        <th>Edition</th>
                    </tr>                        
                    <xsl:for-each select="books/book"> 
                    	<!-- <xsl:sort select="./bookName" order="ascending"/> --> 
                        <xsl:call-template name="book"/>                       
                    </xsl:for-each>  
                </table>
                <br></br>   
                
                <h2>If Condition</h2>
                <xsl:if test="count(/books/book)>2">
                	<xsl:text>
                      	Condition True: Count of books are more than two.
                    </xsl:text>
           		</xsl:if> 
           		<br></br>
           		
           		<h2>Choose (Like Switch Case)</h2>
           		<xsl:choose>
                	<xsl:when test="count(/books/book)=1">
                    	Condition True: Count of book is one.
                    </xsl:when>
                    <xsl:when test="count(/books/book)=2">
                      	Condition True: Count of book is two.
                    </xsl:when>
                    <xsl:when test="count(/books/book)=3">
                        Condition True: Count of book is three.
                    </xsl:when>
                    <xsl:otherwise>
                        No condition match.
                    </xsl:otherwise>
              	</xsl:choose>
              	<br></br>
            	
            	<h2>Commemt</h2>
            		<xsl:comment> This will be printed to output as a comment node.</xsl:comment>
            	<br></br>
            	
            	<h2>Text</h2>
            	<xsl:text>
					This is a text line.
				</xsl:text>
				<br></br>
				 
				<h2>Element</h2>
            	<xsl:element name="bookcode">
                	<xsl:value-of select="/books/book[1]/@id"/>
            	</xsl:element>
            	<br></br>
            	
            	<h2>Sort - By Book Name</h2>
            	<table border = "1">   
                    <tr bgcolor = "#cd8932">   
                        <th>Book ID</th>   
                        <th>Book Name</th>   
                        <th>Author Name</th>   
                        <th>Publisher</th>   
                        <th>Price</th>                           
                        <th>Edition</th>
                    </tr>                        
                    <xsl:for-each select="books/book"> 
                    	<xsl:sort select="./bookName" order="ascending"/> 
                        <xsl:call-template name="book"/>                       
                    </xsl:for-each>  
                </table>
                <br></br>
                
                <h2>Variable - Global</h2>
                <xsl:text> Second Book Name: </xsl:text>
       			<xsl:value-of select="$Secondbook"/>
       			
       			<h2>Variable - Local</h2>
       			<xsl:variable name="Firstbook" select="/books/book[1]/bookName[1]"/>
       			
                <xsl:text> First Book Name: </xsl:text>
       			<xsl:value-of select="$Firstbook"/>
       			<br></br>
       			
       			<h2>Key - value search</h2>
       			<xsl:for-each select = "key('get-publisher', 'Wrox')">
                	<xsl:call-template name="book"/>                       
                </xsl:for-each>
                <br></br>
                
                <h2>Error Meesage</h2>
                <table border = "1">   
                    <tr bgcolor = "#cd8932">   
                        <th>Book ID</th>   
                        <th>Book Name</th>   
                        <th>Author Name</th>   
                        <th>Publisher</th>   
                        <th>Price</th>                           
                        <th>Edition</th>
                    </tr>                        
                    <xsl:for-each select="books/book">
                        <xsl:if test = "price  &lt; 201"> 
                            <xsl:message terminate = "no">
                              	Terminating: price element is lessthan the fixed price. 
                            </xsl:message> 
                        </xsl:if> 
                       <xsl:call-template name="book"/>   
                    </xsl:for-each>
                </table>   
                <br></br>
                
                <h2>Specific List - Book Name</h2>
                <h4>List of Books Name :-</h4>
                <xsl:for-each select="/books/book">
                    <p>
                    <xsl:call-template name="book_name">
                        <xsl:with-param name="BookName" select="bookName"/>
                    </xsl:call-template>
                    </p>
                </xsl:for-each>
                
            </body>   
        </html>   
    </xsl:template>
    
    <xsl:template match="*">
    	<xsl:copy>
     		<xsl:apply-templates select="book"/>
   		</xsl:copy>
  	</xsl:template>
    
    <xsl:template name="book">
        <tr bgcolor = "#84cd32"> 
            <td><xsl:value-of select = "@id"/></td>   
            <td><xsl:value-of select = "bookName"/></td>   
            <td><xsl:value-of select = "authorName"/></td>   
            <td><xsl:value-of select = "publisher"/></td>   
            <td><xsl:value-of select = "price"/></td>                               
            <td><xsl:value-of select = "edition"/></td>
        </tr>
    </xsl:template>
    
    <xsl:template name="book_name">
        <xsl:param name="BookName"/>
        <xsl:text>
            Book Name: </xsl:text><xsl:value-of select="$BookName"/>
    </xsl:template>
    
</xsl:stylesheet>


<!--
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	exclude-result-prefixes="xs" version="2.0">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Books:-</h2>
				<table border="1">
					<tr bgcolor="#cd8932">
						<th>Book ID</th>
						<th>Book Name</th>
						<th>Author Name</th>
						<th>Publisher</th>
						<th>Price</th>
						<th>Edition</th>
					</tr>
					<xsl:apply-templates select="books" />
				</table>
				<br></br>
				
				<h2>Copy - Shallow Copy</h2>
              	<xsl:template match="books/book">
                	<xsl:copy>
             			<xsl:apply-templates select="book"/>
                	</xsl:copy>
            	</xsl:template>
      			<br></br>
      			
      			<h2>Copy-of - Deep Copy</h2>  
      			<xsl:template match="books/book">
                	<xsl:copy-of select="."/>
            	</xsl:template>    	
      
			</body>
		</html>
	</xsl:template>

	<xsl:template match="books">
		<xsl:apply-templates select="book" />
	</xsl:template>

	<xsl:template match="book">
		<tr bgcolor="#84cd32">
			<td> <xsl:value-of select="@id" /> </td>
			<td> <xsl:value-of select="bookName" /> </td>
			<td> <xsl:value-of select="authorName" /> </td>
			<td> <xsl:value-of select="publisher" /> </td>
			<td> <xsl:value-of select="price" /> </td>
			<td> <xsl:value-of select="edition" /> </td>
		</tr>
	</xsl:template>
</xsl:stylesheet> -->