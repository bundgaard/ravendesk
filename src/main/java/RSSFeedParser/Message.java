/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSSFeedParser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbundgaard
 */
public class Message {
    
   /*
    date("date"),
    channel("channel"),
    title("title"),
    author("author"),
    link("link"),
    description("description"),
    language("language"),
    rights("rights"),
    publisher("publisher"),
    image("image"),
    textinput("textinput"),
    subject("subject"),
    creator("creator"),
    updateBase("updateBase"),
    updateFrequency("updateFrequency"),
    updatePeriod("updatePeriod"),
    items("items"),
    info("info"),
    url("url"),
    item("item"),
    Seq("Seq"),
    department("department"),
    section("section"),
    comments("comments"),
    name("name"),
    hit_parade("hit_parade"),
    li("li"),
    // beginning of ABC news
    rss("rss"),
    thumbnail("thumbnail"),
    category("category"),
    pubDate("pubDate"),
    content("content"),
    keywords("keywords"),
    guid("guid");
    */
    private String title;
    private String description;
    private String link;
    private String author;
    private String url;
    private String creatorString;
    private String nameString;
    private final List<Thumbnail> thumbnail = new ArrayList<Thumbnail>();
    
    

    public String getCreatorString() {
        return creatorString;
    }

    public void setCreatorString(String creatorString) {
        this.creatorString = creatorString;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }
    
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "Message [title=" + getTitle() +", description="+getDescription()+", link=" +getLink()+ "]";        
    }

    public List<Thumbnail> getThumbnail() {
        return thumbnail;
    }



   
}
