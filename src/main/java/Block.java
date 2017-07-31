/**
 * Created by GiangNT on 7/31/2017.
 */
public class Block {

    private int id;
    private String type;
    private int lineStart;
    private int lineEnd;

    public Block(int id, String type, int lineStart, int lineEnd) {
        this.id = id;
        this.type = type;
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLineStart() {
        return lineStart;
    }

    public void setLineStart(int lineStart) {
        this.lineStart = lineStart;
    }

    public int getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(int lineEnd) {
        this.lineEnd = lineEnd;
    }
}
