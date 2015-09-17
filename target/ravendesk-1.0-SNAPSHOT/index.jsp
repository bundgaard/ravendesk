<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Ravendesk</title>

        <link rel="shortcut icon" href="/ravendesk/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.common.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.rtl.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.default.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.mobile.all.min.css">

        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/angular.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/jszip.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/kendo.all.min.js"></script></head>
    <body>
        <div id="splitter">
                <div>
                    <ul id="ravenPanelMenu">
                        <li>Add</li>
                        <li>About</li>
                
                    </ul>
                </div>
            <div>
                <div class="k-header wide" >
                    <div id="ravenList"></div>
                    <div id="ravenListPager"></div>
                </div>
            </div>
            
        </div>
        <script id="ravenListTemplate" type="text/x-kendo-template">
            <div class="product">
            
             #for (var i = 0, t = 1; i < t; i++) { #
                <img width="128" height="128 " src="#=thumbnail[i].url#">
                
             #}#
            <h3>#= title #</h3>
            <p><a href="#= link #" class="k-link listitem">Link</a></p>
                
               
            </div>
        </script>

        <script>
function onChage() {
    $("#ravenList").html(kendo.render(kendo.template($("#ravenListTemplate")).html(), this.view()));
}
$(document).ready(function () {
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
    itemsDS.read();
    $("#ravenList").kendoListView({
        dataSource: itemsDS,
        template: kendo.template($("#ravenListTemplate").html())
    });
    $("#ravenListPager").kendoPager({
        dataSource: itemsDS
    });
    
    $("#ravenPanelMenu").kendoPanelBar();
    $("#splitter").kendoSplitter({
        orientation: "horizontal",
        panes: [{collapsible: true, size: "150px"},{collapsible: false}]
    });
    var splitter = $("#splitter").data("kendoSplitter");
    console.log(splitter);

});
        </script>
        <style>
            html, body {
                height: 100%;
                padding: 0;
                margin: 0;
            }
            
            #splitter {
                height: 100%;
            }

            #ravenList {
                padding: 10px 5px;
                margin-bottom: -1px;
                min-height: 510px;
            }
            .product {
                float: left;
                position: relative;
                width: 150px;
                height: 170px;
                margin: 0 5px 15px;
                padding: 0;
            }
            .product img {
                width: 110px;
                height: 110px;
            }
            .product h3 {
                margin: 0;
                padding: 3px 5px 0 0;
                max-width: 96px;
                overflow: hidden;
                line-height: 1.1em;
                font-size: .9em;
                font-weight: normal;
                text-transform: uppercase;
                color: #999;
            }
            .product p {
                visibility: hidden;
            }
            .product:hover p {
                visibility: visible;
                position: absolute;
                width: 110px;
                height: 110px;
                top: 0;
                margin: 0;
                padding: 0;
                line-height: 110px;
                vertical-align: middle;
                text-align: center;
                color: #fff;
                background-color: rgba(75,75,75,0.75);
                transition: background .2s linear, color .2s linear;
                -moz-transition: background .2s linear, color .2s linear;
                -webkit-transition: background .2s linear, color .2s linear;
                -o-transition: background .2s linear, color .2s linear;
            }
            .k-link .listitem {
                color: #ffffff !important;
            }
            .k-listview:after {
                content: ".";
                display: block;
                height: 0;
                clear: both;
                visibility: hidden;
            }

        </style>

    </body>
</html>