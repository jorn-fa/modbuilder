package jorn.hiel;

import jorn.hiel.helper.XmlReader;
import jorn.hiel.helper.XmlWriter;
import jorn.hiel.parts.StoreData;
import jorn.hiel.parts.VehicleXml;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.lang.annotation.Documented;

public class ModBuilder implements Runnable{

    private Logger log = Logger.getLogger("modbuilder");




    //todo veranderen
    private String fileLocation =System.getProperty("user.dir")+"-src-main-resources-input.i3d".replace("-", File.separator);;


    private void readXml()
    {
        XmlReader xmlReader= new XmlReader(fileLocation);


    }

    private void writeXml(StoreData storeData){
        //XmlWriter xmlWriter = new XmlWriter();
        //xmlWriter.vuller(storeData);

    }

    private void generateVehicle(Document document) {
        log.debug("generate vehicle xml");

        //todo opkuisen

        XmlWriter xmlWriter=new XmlWriter();
        xmlWriter.writeFile(document);

    }

    private Document generateDocument(){
        Document document = null;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            log.debug("error in generateDocument");
            log.debug(e.getMessage());
        }

        return document;
    }


    @Override
    public void run() {

        System.out.println( fileLocation);
    }

    public static void main(String[] args) {

        ModBuilder a = new ModBuilder();

        StoreData storeData = new StoreData();

        storeData.setBrand("Lizard");
        storeData.setPrice("165000");
        storeData.setName("a Helmer Kraan Truck");
        storeData.setPower("480");
        storeData.setMaxSpeed("80");

        VehicleXml vehicleXml = new VehicleXml();
        vehicleXml.setType("sx210Bale");
        vehicleXml.setFilename("test.i3d");

        //a.writeXml(storeData);

        Document document = a.generateDocument();
        vehicleXml.generate(document);
        //System.out.println(document.getElementById("vehicle"));
        //document=storeData.generate(document);

        a.generateVehicle(document);



    }


}
