import java.io.Serializable;
import java.util.Date;

public class Container implements Serializable
{

    private Date date;
    private String content;

    public Container()
    {
        this.content="";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
