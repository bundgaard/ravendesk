/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSSFeedParser;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author dbundgaard
 */
public class Feed {
    
    private final String title;
    private final String link;
    private final String description;
    
    private final List<Message> entries = new ArrayList<Message>();
    
    public Feed(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }
    
    public List<Message> getMessages() {
        return entries;
    }
    


    @Override
    public String toString() {
        return "Feed [title= " + getTitle() + ", link=" + getLink() + ", description= " + getDescription()+ "]";
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
}
