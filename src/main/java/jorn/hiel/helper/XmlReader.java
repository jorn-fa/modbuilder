package jorn.hiel.helper;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlReader {

    private String fileName;

    public XmlReader(String fileName){
        this.fileName=fileName;
        giveLenght();
        test();
    }


    private void giveLenght(){
        try {

            Path logfile = Paths.get(fileName);
            String content = new String(Files.readAllBytes(logfile), StandardCharsets.UTF_8);
            int teller = content.length();

            System.out.println(teller);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void test(){
        String temp = "0>";

        try {
            File file = new File(fileName);


            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();

            Document doc = dBuilder.parse(file);
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            //if (doc.hasChildNodes()) {
                //printNote(doc.getChildNodes());
            //}

            NodeList nodeList = doc.getElementsByTagName("TransformGroup");

            for (int j = 0; j < nodeList.getLength(); ++j) {
                Node prop = nodeList.item(j);


                NamedNodeMap attr = prop.getAttributes();
                if (null != attr) {

                    Node p = attr.getNamedItem("name");


                    if (p.getNodeValue().toString().equals("exitPoint")){
                        temp=temp+j;


                    }

                    System.out.println(p.getNodeValue());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println( temp);

    }

    private static void printNote(NodeList nodeList) {

        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                // get node name and value
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());

                    }

                }

                if (tempNode.hasChildNodes()) {

                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());

                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

            }

        }

    }


}
