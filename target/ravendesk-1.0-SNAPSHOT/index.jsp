<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Ravendesk</title>

        <link rel="shortcut icon" href="/ravendesk/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/ravendesk/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.common-material.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.rtl.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.materialblack.min.css">
        <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2015.2.805/styles/kendo.mobile.all.min.css">
        
        <link rel="stylesheet" href="site/css/indexlayout.css">

        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/angular.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/jszip.min.js"></script>
        <script src="http://kendo.cdn.telerik.com/2015.2.805/js/kendo.all.min.js"></script>
        <script src="site/indexlogic.js"></script>
    </head>
    <body>
        <div id="splitter">
            <div>
                <div id="topbar" style="padding-left: 10px;">
                    <button class="k-button" id="addbtn">Add</button>
                    
                </div>
                <ul id="ravenPanelMenu">
                    <li id="feedItems">Favorite feeds
                        <ul >
                            <li>No feeds</li>
                        </ul>
                    </li>                
                </ul>
            </div>
            <div id="horizontal">
                <div class="k-header tall" style="height: 100%">
                    <div id="ravenList"></div>
                    <div id="ravenListPager"></div>
                </div>
            </div>

        </div>
        <div id="ravenAddWindow">
            <div class="k-widget">
                <label for="feedname">Feed URL:</label>
                <input type="text" name="feedname" class="k-textbox">
                <input type="button" class="k-button" name="ravenWindowAdd" value="Add">
                <input type="button" class="k-button" name="ravenWindowClose" value="Close">
            </div>
        </div>
        <script id="ravenListTemplate" type="text/x-kendo-template">
            <div class="product">

            #for (var i = 0, t = 1; i < t; i++) { #
            <img width="128" height="128 " src="#=thumbnail[i].url#">

            #}#
            <h3>#= title #</h3>
            <p><a href="#= link #" class="k-link listitem" target="_new">Link</a></p>


            </div>
        </script>

    </body>
</html>
