import java.util.ArrayList;

/**
 * Created by GiangNT on 7/31/2017.
 */
public class XmlFile {
    private String fileName;

    public XmlFile(String fileName) {
        this.fileName = fileName;
        this.blocks = new ArrayList<Block>();
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private ArrayList<Block> blocks;

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

}
