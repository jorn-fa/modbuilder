package jorn.hiel.helper;

import jorn.hiel.parts.StoreData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlWriter {

    String waar = System.getProperty("user.dir")+"-src-main-resources-test.xml";


    public void writeFile(Document document){
        try {

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount","4");
            DOMSource source = new DOMSource(document);


            waar=waar.replace("-", File.separator);
            //StreamResult result = new StreamResult(new File(waar));

            // Output to console for testing
            StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    }