__CreateJSPath = function (js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}

var bootPATH = __CreateJSPath("boot.js");

//debugger
mini_debugger = true;   

//miniui
document.write('<script src="' + bootPATH + 'jquery-1.6.2.min.js" type="text/javascript"></sc' + 'ript>');
document.write('<script src="' + bootPATH + 'miniui/miniui.js" type="text/javascript" ></sc' + 'ript>');
document.write('<link href="' + bootPATH + 'miniui/themes/default/miniui.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + bootPATH + 'miniui/themes/blue/skin.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + bootPATH + 'miniui/themes/icons.css" rel="stylesheet" type="text/css" />');

//skin
var skin = getCookie("miniuiSkin");
if (skin) {
    document.write('<link href="' + bootPATH + 'miniui/themes/' + skin + '/skin.css" rel="stylesheet" type="text/css" />');
}


////////////////////////////////////////////////////////////////////////////////////////
function getCookie(sName) {
    var aCookie = document.cookie.split("; ");
    var lastMatch = null;
    for (var i = 0; i < aCookie.length; i++) {
        var aCrumb = aCookie[i].split("=");
        if (sName == aCrumb[0]) {
            lastMatch = aCrumb;
        }
    }
    if (lastMatch) {
        var v = lastMatch[1];
        if (v === undefined) return v;
        return unescape(v);
    }
    return null;
}

//var data = {a:a,b:b,c:[{a:a,b:b,c:[]}]}
/**
 * 获取一个用于提交的对象
 * @param {} expr
 */
function getSubmitParams(expr,params){
    var allfields=[];
    var fields;
    var $expr;
    if(typeof expr == 'string')
        $expr=$(expr);
    else
        $expr = expr;
    // 过滤非单选复选
    fields=$expr.filter(function(idx){ return $(this).attr("name") != null
        && $(this).attr("type") != 'checkbox'
        && $(this).attr("type") != 'radio';});

    for(var i=0;i<fields.length;i++){
        allfields.push(fields.eq(i));
    }
    //过滤单选复选
    fields = $expr.filter(function(idx){ return $(this).attr("name") != null && $(this).attr("checked") == true});
    for(var i=0;i<fields.length;i++){
        allfields.push(fields.eq(i));
    }
    //设置对象
    if(!params)
        var params = {};

    for(var i=0;i<allfields.length;i++){
    	if(allfields[i].val()){
    		params[allfields[i].attr('name')] = allfields[i].val();
    	}
    }

    function buildParams(data) {
        var para = {};

        for(var r in data) {
            var rArr = r.split(".");
            if(rArr.length>1){
                var tpParent=para[rArr[0]];
                if(!tpParent)
                    tpParent=para[rArr[0]]={};
                for(var v=1;v< rArr.length-1;v++){
                    if(!tpParent[rArr[v]]){
                        tpParent[rArr[v]]={};
                        tpParent=tpParent[rArr[v]];
                    }

                }
                tpParent[rArr[rArr.length-1]] = data[r];
            }
            else {
                para[r] = data[r];
            }
        }
        return para;
    }
    return buildParams(params);
}

var WinAlerts = window.alert;
window.alert = function (e) {
    if (e != null && e.indexOf("试用到期 www.miniui.com")>-1){

    }
    else
    {
        WinAlerts (e);
    }

};