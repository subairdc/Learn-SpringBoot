package com.subair.spring.xslt;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.spi.TransformerException;

@RestController
@RequestMapping("/xslt")
public class XsltController {
	
	@GetMapping(value = "transform")
    @ResponseBody
    public String xmlToXslt() throws TransformerException, IOException, javax.xml.transform.TransformerException {

        // Load the XML file from the classpath
        ClassPathResource xmlResource = new ClassPathResource("books.xml");
        InputStream xmlInputStream = xmlResource.getInputStream();

        // Load the XSLT file from the classpath
        ClassPathResource xslResource = new ClassPathResource("books.xsl");
        InputStream xslInputStream = xslResource.getInputStream();
        
//        Source xmlSource = new StreamSource(new File("src\\main\\resources\\books.xml"));
//        Source xsltSource = new StreamSource(new File("src\\main\\resources\\books.xsl"));

        // Create the transformer factory and transformer
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslInputStream));

        // Perform the transformation
        
        Source source = new StreamSource(xmlInputStream);
        StringWriter resultWriter = new StringWriter();
        StreamResult result = new StreamResult(resultWriter);
        transformer.transform(source, result);

        // Get the result as a string and return it as the response body
        String htmlResult = resultWriter.toString();
        return htmlResult;
    }

}