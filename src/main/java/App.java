import java.util.ArrayList;

/**
 * Created by GiangNT on 7/26/2017.
 */
public class App {
    public static void main(String[] args) {
        String sampleDir = "C:\\Users\\GiangNT\\Desktop\\test\\test sample 2";
        String outputDir = "C:\\Users\\GiangNT\\Desktop\\test\\test output 2";

        ArrayList<XmlFile> sampleList = new ArrayList<XmlFile>();
        ArrayList<XmlFile> outputList = new ArrayList<XmlFile>();
        Checker checker = new Checker();
        checker.initXmlBlockList(sampleDir, outputDir, sampleList,outputList);
        checker.compareList(sampleList,outputList);
    }
}
