/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSSFeedParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author dbundgaard
 */
public class RSSFeedParser {

    private final URL url;

    public RSSFeedParser(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public Feed feed() {
        Feed feed = null;
        try {
            String date = "";
            String title = "";
            String channel = "";
            String link = "";
            String description = "";
            String author = "";
            String url = "";
            Thumbnail thumbnail = null;

            boolean isHeader = true;

            URL l_url = getUrl();
            URLConnection c = l_url.openConnection();
            XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = xmlFactory.createXMLEventReader(c.getInputStream());
            List<Thumbnail> thumbnails = new ArrayList<Thumbnail>();
            while (xmlEventReader.hasNext()) {               
                XMLEvent event = xmlEventReader.nextEvent();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();
                    ElementEnum e = ElementEnum.valueOf(localPart);

                    switch (e) {
                        case item: {
                            if (isHeader) {
                                isHeader = false;
                                feed = new Feed(title, link, description);
                            }
                        }
                        case date: {
                            date = getCharacterData(event, xmlEventReader);
                            break;
                        }
                        case title: {
                            title = getCharacterData(event, xmlEventReader);
                            break;
                        }
                        case channel: {
                            channel = getCharacterData(event, xmlEventReader);
                            break;
                        }
                        case description: {
                            description = getCharacterData(event, xmlEventReader);
                            break;
                        }
                        case link: {
                            link = getCharacterData(event, xmlEventReader);
                            break;
                        }
                        case author: {
                            author = getCharacterData(event, xmlEventReader);
                            break;
                        }
                        case url: {
                            url = getCharacterData(event, xmlEventReader);
                            break;
                        }
                        case thumbnail: {
                            
                            Iterator<Attribute> attribute = event.asStartElement().getAttributes();
                            System.out.print("INSIDE thumbnail, ");
                            Thumbnail t = new Thumbnail();
                            while (attribute.hasNext()) {
                                Attribute insideElementAttribute = attribute.next();
                                System.out.print(" " + insideElementAttribute.getName().toString() + " ");
                                AttributeEnum attributeE = AttributeEnum.valueOf(insideElementAttribute.getName().toString());
                                StringBuilder sb = new StringBuilder();
                                switch(attributeE) {
                                    case height: {
                                        System.out.println("Inside height enum: " + insideElementAttribute.getValue());
                                        t.setHeight(insideElementAttribute.getValue());
                                        break;
                                    }
                                    case width: {
                                        System.out.println("Inside width enum: " + insideElementAttribute.getValue());
                                        t.setWidth(insideElementAttribute.getValue());
                                        break;
                                    }
                                    case url: {
                                        System.out.println("Inside url enum: " + insideElementAttribute.getValue());
                                        t.setUrl(insideElementAttribute.getValue());
                                        break;
                                    }
                                    case credit: {
                                        System.out.println("Inside credit enum: " + insideElementAttribute.getValue());
                                        t.setCredit(insideElementAttribute.getValue());
                                        break;
                                    }
                                }
                               
                            }
                            thumbnail = t;

                            break;
                        }
                        default: {

                        }
                    }

                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equals(ElementEnum.item.toString())) {
                        Message m = new Message();
                        m.setTitle(title);
                        m.setLink(link);
                        m.setDescription(description);
                        m.setAuthor(author);
                        m.setUrl(url);
                        m.getThumbnail().add(thumbnail);

                        feed.getMessages().add(m);
                        
                    }
                }
                //thumbnails.clear();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    private String getCharacterData(XMLEvent event, XMLEventReader xmlEventReader) throws XMLStreamException {
        String result = "";
        event = xmlEventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return url;
    }
}
