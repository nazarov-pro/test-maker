/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.tests;

import az.shahin.pojo.TestPojo;
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
public class XMLContinue {
    public XMLContinue(int id){
        try {
            List<TestPojo> alltestpojo = getAllEmloyee(id);
            if(alltestpojo != null){
            Iterator<TestPojo> iter = alltestpojo.iterator();
            while(iter.hasNext()){
                TestPojo pojo = iter.next();
                if(new TestsSQL().getTestoPjo(pojo.getTestId()) == null){
                    iter.remove();
                }
            }
            createXML(alltestpojo, id);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLContinue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLContinue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLContinue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLContinue.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void removeLog(int id) {
        //List<TestPojo> testslist = new ArrayList<>();
        File inputFile = new File("src/" + id + "_log.xml");
        if (inputFile.exists()) {
            inputFile.delete();
        }
    }
    private int seconds = -1;

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public List<TestPojo> getAllEmloyee(int id) throws ParserConfigurationException, SAXException, IOException {
        List<TestPojo> testslist = new ArrayList<>();
        File inputFile = new File("src/" + id + "_log.xml");
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
        Element shaheen = document.getDocumentElement();
        seconds = Integer.parseInt(shaheen.getAttribute("time"));
        //System.out.println("Root Element : "+document.getDocumentElement().getNodeName() + "\nRoot Value : "+document.getDocumentElement().getNodeName());
        NodeList nodelist = document.getElementsByTagName("test");
        for (int temp = 0; temp < nodelist.getLength(); temp++) {
            TestPojo pojo = new TestPojo();
            Node node = nodelist.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                List<String> answers = new ArrayList<>();
                answers.add(element.getAttribute("var_A"));
                answers.add(element.getAttribute("var_B"));
                answers.add(element.getAttribute("var_C"));
                answers.add(element.getAttribute("var_D"));
                answers.add(element.getAttribute("var_E"));
                pojo.setAnswers(answers);
                pojo.setTestId(Integer.parseInt(element.getTextContent()));
                pojo.setAnswer(Integer.parseInt(element.getAttribute("correct_v")));
                pojo.setMode(Integer.parseInt(element.getAttribute("mode")));
                pojo.setMyselected(Integer.parseInt(element.getAttribute("my_answer")));
             //   System.out.println("pojo "+pojo.getMyselected());

            }
            testslist.add(pojo);
        }
        return testslist;
    }

    public void createXML(List<TestPojo> backup, int id) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbfactory.newDocumentBuilder();
        Document document = builder.newDocument();
        //root Element
        Element rootElement = document.createElement("shaheen");
        Attr secatr = document.createAttribute("time");
        secatr.setValue(String.valueOf(seconds));
        rootElement.setAttributeNode(secatr);
        document.appendChild(rootElement);
        //employee elemnt
        for (TestPojo pojo : backup) {
            List<String> answers = pojo.getAnswers();

            Element testElement = document.createElement("test");
            testElement.appendChild(document.createTextNode(String.valueOf(pojo.getTestId())));
            rootElement.appendChild(testElement);
            //employee number
            Attr attributeEmployeeA = document.createAttribute("var_A");
            attributeEmployeeA.setValue(String.valueOf(answers.get(0)));
            testElement.setAttributeNode(attributeEmployeeA);

            Attr attributeEmployeeB = document.createAttribute("var_B");
            attributeEmployeeB.setValue(String.valueOf(answers.get(1)));
            testElement.setAttributeNode(attributeEmployeeB);

            Attr attributeEmployeeC = document.createAttribute("var_C");
            attributeEmployeeC.setValue(String.valueOf(answers.get(2)));
            testElement.setAttributeNode(attributeEmployeeC);

            Attr attributeEmployeeD = document.createAttribute("var_D");
            attributeEmployeeD.setValue(String.valueOf(answers.get(3)));
            testElement.setAttributeNode(attributeEmployeeD);

            Attr attributeEmployeeE = document.createAttribute("var_E");
            attributeEmployeeE.setValue(String.valueOf(answers.get(4)));
            testElement.setAttributeNode(attributeEmployeeE);

            Attr mode = document.createAttribute("mode");
            mode.setValue(String.valueOf(pojo.getMode()));
            testElement.setAttributeNode(mode);

            Attr myans = document.createAttribute("my_answer");
            myans.setValue(String.valueOf(pojo.getMyselected()));
            testElement.setAttributeNode(myans);

            Attr correct = document.createAttribute("correct_v");
            correct.setValue(String.valueOf(pojo.getAnswer()));
            testElement.setAttributeNode(correct);
            //firstname
        }
        //write context
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        File file = new File("src/" + id + "_log.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

}
