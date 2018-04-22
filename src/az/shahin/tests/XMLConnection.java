/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.tests;

import az.shahin.pojo.XMLTestModel;
import az.shahin.sql.TestsSQL;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class XMLConnection {

    public XMLConnection(int id) {
        try {
            List<XMLTestModel> getALTestModels = getAllEmloyee(id);
            if (getALTestModels != null) {
                Iterator<XMLTestModel> iterator = getALTestModels.iterator();
                while (iterator.hasNext()) {
                    XMLTestModel model = iterator.next();
                    Iterator<Integer> ierator2 = model.getTests().iterator();
                    while (ierator2.hasNext()) {
                        Integer a = ierator2.next();
                        if (new TestsSQL().getTestoPjo(id) == null) {
                            ierator2.remove();
                        }
                    }
                }
                createXML(getALTestModels.get(0));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<XMLTestModel> getAllEmloyee(int id) throws ParserConfigurationException, SAXException, IOException {
        List<XMLTestModel> testslist = new ArrayList<>();
        File inputFile = new File("src/" + id + ".xml");
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
        NodeList nodelist = document.getElementsByTagName("user");
        for (int temp = 0; temp < nodelist.getLength(); temp++) {
            XMLTestModel pojo = new XMLTestModel();
            Node node = nodelist.item(temp);
            List<Integer> intlist = new ArrayList<>();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                pojo.setId(Integer.parseInt(element.getAttribute("id")));
                NodeList alltests = element.getElementsByTagName("test");
                for (int temp2 = 0; temp2 < alltests.getLength(); temp2++) {
                    Node node1 = alltests.item(temp2);
                    if (node1.getNodeType() == node1.ELEMENT_NODE) {
                        Element test = (Element) node1;
                        intlist.add(Integer.parseInt(test.getTextContent()));
                    }
                }
                pojo.setTests(intlist);
            }
            testslist.add(pojo);
        }
        return testslist;
    }

    public void createXML(XMLTestModel pojo) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbfactory.newDocumentBuilder();
        Document document = builder.newDocument();
        //root Element
        Element rootElement = document.createElement("shaheen");
        document.appendChild(rootElement);
        //employee elemnt
        Element employeeElement = document.createElement("user");
        rootElement.appendChild(employeeElement);
        //employee number
        Attr attributeEmployee = document.createAttribute("id");
        attributeEmployee.setValue(String.valueOf(pojo.getId()));
        employeeElement.setAttributeNode(attributeEmployee);
        //firstname
        for (int testid : pojo.getTests()) {
            Element salary = document.createElement("test");
            salary.appendChild(document.createTextNode(String.valueOf(testid)));
            employeeElement.appendChild(salary);
        }
        //write context
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        File file = new File("src/" + pojo.getId() + ".xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

}
