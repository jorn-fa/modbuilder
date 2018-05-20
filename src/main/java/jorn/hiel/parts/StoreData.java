package jorn.hiel.parts;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;


public class StoreData {




    public HashMap<String, String> lijst = new HashMap<>();


    public HashMap<String, String> getLijst() {
        return lijst;
    }


    public void setName(String name) {
        lijst.put("name", name);
    }

    public void setFunction(String function) {
        lijst.put("function", function);
    }


    public void setImage(String image) {
        lijst.put("image", image);
    }

    public void setBrand(String brand) {
        lijst.put("brand",brand);
    }

    public void setCategory(String category) {
        lijst.put("category",category);
    }

    public void setLifeTime(String lifeTime) {
        lijst.put("lifeTime",lifeTime);
    }

    public void setRotation(String rotation) {
        lijst.put("rotation",rotation);
    }

    public void setDailyUpkeep(String dailyUpkeep) {
        lijst.put("dailyUpkeep", dailyUpkeep);
    }

    public void setPower(String power) {
        lijst.put("power",power);
    }

    public void setMaxSpeed(String maxSpeed) {
        lijst.put("maxSpeed",maxSpeed);
    }

    public void setPrice(String price) {
        lijst.put("price",price);
    }

    public void setFieldJob(String fieldJob) {
        lijst.put("fieldJob", fieldJob);
    }

    public void setCombination(String combination) {
        lijst.put("combination",combination);
    }

    public void setWorkingWidth(String workingWidth){
        lijst.put("workingWidth",workingWidth);
    }

    public Document generate(Document document) {

        Element rootElement = document.createElement("storeData");
        boolean specsDone=false;


        for (Map.Entry<String, String> entry : lijst.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if(key.equals("name")) {

                Element name = document.createElement(entry.getKey());
                Element en = document.createElement("en");
                name.appendChild(document.createTextNode(""));
                en.appendChild(document.createTextNode(entry.getValue()));
                rootElement.appendChild(name);
                name.appendChild(en);
            }

            if(key.equalsIgnoreCase("power")||key.equalsIgnoreCase("maxspeed")||key.equalsIgnoreCase("combination")
                    ||key.equalsIgnoreCase("workingWidth")){

                if (!specsDone) {
                    Element specs = document.createElement("specs");
                    Element name = document.createElement(entry.getKey());
                    name.appendChild(document.createTextNode(entry.getValue()));
                    rootElement.appendChild(specs);
                    specs.appendChild(name);
                    if(lijst.get("maxSpeed")!=null) {
                        Element maxspeed = document.createElement("maxSpeed");
                        maxspeed.appendChild(document.createTextNode(lijst.get("maxSpeed")));
                        specs.appendChild(maxspeed);
                    }
                    if(lijst.get("combination")!=null) {
                        Element combination = document.createElement("combination");
                        combination.appendChild(document.createTextNode(lijst.get(combination)));
                        specs.appendChild(combination);
                    }

                    if(lijst.get("workingWidth")!=null) {
                        Element workingWidth = document.createElement("workingWidth");
                        workingWidth.appendChild(document.createTextNode(lijst.get(workingWidth)));
                        specs.appendChild(workingWidth);
                    }
                    

                    specsDone=true;
                }

            }



        }

        document.appendChild(rootElement);

        return document;
    }
}
