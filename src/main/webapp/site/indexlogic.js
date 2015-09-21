/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var indexApp = (function ($, fm, tl, kendo, console) {
});

function onChage() {
    $("#ravenList").html(kendo.render(kendo.template($("#ravenListTemplate")).html(), this.view()));
}


var feedList = {feeds: [
    {title: "Title1", address: "address goes here!"},
    {title: "Title1", address: "address goes here!"},
    {title: "Title1", address: "address goes here!"},
    {title: "Title1", address: "address goes here!"}
]};



var itemsDS = new kendo.data.DataSource({
    transport: {
        read: {
            url: '/ravendesk/transcode/',
            data: {
                q: "http://feeds.abcnews.com/abcnews/topstories"
            }
        } //end of read
    }, //endofTransport
    schema: {
        data: "messages",
        total: function (resp) {
            return resp.messages.length;
        },
        model: {
            fields: [
                {title: "title"},
                {description: "description"},
                {link: "link"},
                {thumbnail: "thumbnail"}
            ]
        }
    }, // end of schema
    pageSize: 15
            /*change: onChage*/
});

$(document).ready(function () {
    itemsDS.read();
    $("#addFeedBtn").click(function () {
        var addWindow = $("#ravenAddWindow").data("kendoWindow");
        addWindow.center();
        addWindow.open();
    });
    $("#ravenList").kendoListView({
        dataSource: itemsDS,
        template: kendo.template($("#ravenListTemplate").html())
    });
    $("#ravenListPager").kendoPager({
        dataSource: itemsDS
    });
    $("input[name=ravenWindowClose]").click(function () {
        var addWindow = $("#ravenAddWindow").data("kendoWindow");
        addWindow.close();
    });

    $("#ravenPanelMenu").kendoPanelBar({
        expanded: true
    });

    $("#splitter").kendoSplitter({
        orientation: "horizontal",
        panes: [{collapsible: true, size: "180px"}, {collapsible: false}]
    });
    $("#ravenAddWindow").kendoWindow({
        action: ["Close"],
        title: "Feed [Add]",
        visible: false
    });
    var ravenPanelFeed = $("#ravenPanelMenu").data("kendoPanelBar");
    var splitter = $("#splitter").data("kendoSplitter");
    var feedsDS = new kendo.data.DataSource({
        data: {feeds: [{title:"hej"},{title: "med"}]},
        schema: {
            data: "feeds"
        }
    });
    var template=kendo.template("#=title#");
    console.log(feedsDS, template(feedsDS));
    ravenPanelFeed.expand($("#feedItems"));

});
