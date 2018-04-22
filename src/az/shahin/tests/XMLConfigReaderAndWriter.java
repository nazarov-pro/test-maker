/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.tests;

import az.shahin.pojo.ConfigPojo;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class XMLConfigReaderAndWriter {

    public XMLConfigReaderAndWriter() {

    }
    File inputFile = new File("src/configration.xml");

    public ConfigPojo readData() throws IOException, SAXException, ParserConfigurationException {
        ConfigPojo configpojo = null;

        if (!inputFile.exists()) {
            inputFile.createNewFile();
            return null;
        } else if (inputFile.length() < 10) {
            return null;
        }
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbfactory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        document.getDocumentElement().normalize();
        //System.out.println("Root Element : "+document.getDocumentElement().getNodeName() + "\nRoot Value : "+document.getDocumentElement().getNodeName());
        Node node = document.getElementsByTagName("config").item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            // System.out.println(element.getElementsByTagName("host").item(0).getTextContent());
            configpojo = new ConfigPojo();
            configpojo.setHost(element.getElementsByTagName("host").item(0).getTextContent());
            configpojo.setUsername(element.getElementsByTagName("username").item(0).getTextContent());
            configpojo.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
            configpojo.setAdminsPassword(element.getElementsByTagName("adminspass").item(0).getTextContent());
            configpojo.setTip(false);
            if (Integer.parseInt(element.getElementsByTagName("tips").item(0).getTextContent()) == 1) {
                configpojo.setTip(true);
            }
        }
        return configpojo;
    }

    public void writeData(ConfigPojo data) throws ParserConfigurationException, TransformerConfigurationException, IOException, TransformerException {
        if (!inputFile.exists()) {
            inputFile.createNewFile();
        }
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbfactory.newDocumentBuilder();
        Document document = builder.newDocument();
        //root Element
        Element rootElement = document.createElement("shaheen");
        document.appendChild(rootElement);
        //employee elemnt
        Element employeeElement = document.createElement("config");
        rootElement.appendChild(employeeElement);
        //employee number
        Element host = document.createElement("host");
        host.appendChild(document.createTextNode(data.getHost()));
        employeeElement.appendChild(host);
        //employee number
        Element username = document.createElement("username");
        username.appendChild(document.createTextNode(data.getUsername()));
        employeeElement.appendChild(username);
        //employee number
        Element password = document.createElement("password");
        password.appendChild(document.createTextNode(data.getPassword()));
        employeeElement.appendChild(password);
        //employee number
        Element admins = document.createElement("adminspass");
        admins.appendChild(document.createTextNode(data.getAdminsPassword()));
        employeeElement.appendChild(admins);
        //employee number
        Element tips = document.createElement("tips");
        if (data.isTip()) {
            tips.appendChild(document.createTextNode("1"));
        } else {
            tips.appendChild(document.createTextNode("0"));
        }
        employeeElement.appendChild(tips);
        //write context
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        File file = new File("src/configration.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

}
