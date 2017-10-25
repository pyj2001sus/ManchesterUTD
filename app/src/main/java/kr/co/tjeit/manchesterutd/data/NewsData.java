package kr.co.tjeit.manchesterutd.data;

import java.io.Serializable;

/**
 * Created by the on 2017-10-25.
 */

public class NewsData implements Serializable {

    private String imgURL;
    private String newsHeadLine;
    private String Content;

    public NewsData() {
    }

    public NewsData(String imgURL, String newsHeadLine, String content) {
        this.imgURL = imgURL;
        this.newsHeadLine = newsHeadLine;
        Content = content;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getNewsHeadLine() {
        return newsHeadLine;
    }

    public void setNewsHeadLine(String newsHeadLine) {
        this.newsHeadLine = newsHeadLine;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
