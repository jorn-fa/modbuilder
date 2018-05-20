package jorn.hiel.parts;

import jorn.hiel.parts.StoreData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

public class VehicleXml {

    public HashMap<String, String> lijst = new HashMap<>();

    private String type, annotation, typeDesc, filename, width, length;


    public void setType(String type) {
        lijst.put("type", type);
    }

    public void setAnnotation(String annotation) {
        lijst.put("annotation", annotation);
    }

    public void setTypeDeso(String typeDesc) {
        lijst.put("typeDesc", typeDesc);
    }

    public void setFilename(String filename) {
        lijst.put("filename", filename);
    }

    public void setWidth(String width) {
        lijst.put("width", width);
    }

    public void setLength(String length) {
        lijst.put("length", length);
    }

    private HashMap<String, String> getLijst() {
        return lijst;
    }

    public Document generate(Document document) {

        Element rootElement = document.createElement("Vehicle");
        rootElement.setNodeValue("twew");
        boolean specsDone = false;


        for (Map.Entry<String, String> entry : lijst.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(entry.getValue());


            Element name = document.createElement(entry.getKey());
            name.appendChild(document.createTextNode(entry.getValue()));
            rootElement.appendChild(name);




        }
        document.appendChild(rootElement);
        return document;
    }
}
