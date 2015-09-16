/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSSFeedParser;

/**
 *
 * @author dbundgaard
 */
public enum ElementEnum {
    // Beginning of Slashdot
    RDF("rdf"),    
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
    String type;

    ElementEnum(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
