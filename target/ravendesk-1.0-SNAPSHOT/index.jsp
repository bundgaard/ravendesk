<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Ravendesk</title>

        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.common.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.rtl.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.default.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.mobile.all.min.css">

        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/angular.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/jszip.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/kendo.all.min.js"></script></head>
    <body>
        <div id="ravenList"></div>
        <script id="ravenListTemplate" type="text/x-kendo-template">
            <div>
                <p><img src="# thumbnail[0].url #">&nbsp;#= title # [<a class="k-link" href="#= link #">Link</a>]</p>
                
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
                url: '/ravendesk/transcode/http://feeds.abcnews.com/abcnews/topstories',
            } //end of read
        }, //endofTransport
        schema: {
            data: "messages",
            model: {
                fields: [
                    {title: "title"},
                    {description: "description"},
                    {link: "link"},
                    {thumbnail: "thumbnail"}
                ]
            }
        }, // end of schema
        /*change: onChage*/
    });
    itemsDS.read();
    $("#ravenList").kendoListView({
        dataSource: itemsDS,
        template: kendo.template($("#ravenListTemplate").html())

    });
});
        </script>
    </body>
</html>