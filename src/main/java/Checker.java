import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by GiangNT on 7/26/2017.
 */
public class Checker {

    public XmlFile getBlockByFile(File xmlFile){
        XmlFile newXml = new XmlFile(xmlFile.getName());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList blockList = document.getElementsByTagName("block");
            for (int  temp = 0; temp < blockList.getLength(); temp++){
                Node item= blockList.item(temp);
                if (item.getNodeType() == Node.ELEMENT_NODE){
                    Element block = (Element) item;
                    int id = Integer.parseInt(block.getElementsByTagName("id").item(0).getTextContent());
                    int lineStart = Integer.parseInt(block.getElementsByTagName("line-start").item(0).getTextContent());
                    int lineEnd = Integer.parseInt(block.getElementsByTagName("line-end").item(0).getTextContent());
                    NodeList typeList = block.getElementsByTagName("type");
                    String type = "";
                    if (typeList.getLength() > 0){
                        type = typeList.item(0).getTextContent();
                    }

                    Block newBlock = new Block(id, type, lineStart,lineEnd);

                    newXml.getBlocks().add(newBlock);

                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return newXml;
    }

    public File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".xml"); }
        } );

    }
    public void initXmlBlockList(String sampleDir, String outputDir, ArrayList<XmlFile> sampleList, ArrayList<XmlFile> outputList) {
        File sampleFile[] = finder(sampleDir);
        File outputFile[] = finder(outputDir);
        for (File file:  sampleFile) {
            XmlFile xml = getBlockByFile(file);
            sampleList.add(xml);
        }
        for (File file:  outputFile) {
            XmlFile xml = getBlockByFile(file);
            outputList.add(xml);
        }

    }
    public void compareList(ArrayList<XmlFile> sampleList, ArrayList<XmlFile> outputList){
        for (XmlFile sample : sampleList){
            for (XmlFile output: outputList){
                if (sample.getFileName().equals(output.getFileName())){
                    compareXml(sample,output);
                    break;
                }
            }
        }
    }

    private void compareXml(XmlFile sample, XmlFile output) {
        System.out.println("Checking: " + sample.getFileName());
        for (Block block1 : sample.getBlocks()){
            boolean matched = false;
            for (Block block2 : output.getBlocks()){
                if (block1.getLineStart() == block2.getLineStart() && block1.getLineEnd() == block2.getLineEnd()){
                    System.out.println(block1.getType() + " MATCHED");
                    matched = true;
                }

            }
            if (!matched){
                System.out.println(block1.getType() + " DOESN'T MATCHED");
            }
        }
        System.out.println("------------------------------------------------------");
    }
}
