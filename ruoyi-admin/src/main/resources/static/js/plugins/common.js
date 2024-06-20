function roll(scrollContent,t) {

    var timer = setInterval(rollStart(scrollContent), t); // 间隔时间t
    // 鼠标移入table时暂停滚动
    table.onmouseover = function () {
        clearInterval(timer);
    };
    // 鼠标移出table后继续滚动
    table.onmouseout = function () {
        timer = setInterval(rollStart, t);
    };
}

// 开始滚动函数
function rollStart(scrollContent) {

    // 正常滚动不断给scrollTop的值+1,当滚动高度大于列表内容高度时恢复为0
    if (scrollContent.scrollTop >= scrollContent.scrollHeight / 2) {
        //注此处高度相当于为俩个tbody高度 需除2
        scrollContent.scrollTop = 0;
    } else {
        scrollContent.scrollTop++;
    }
}

//全屏方法
function requestFullScreen(element) {
    // 判断各种浏览器，找到正确的方法
    var requestMethod = element.requestFullScreen || //W3C
        element.webkitRequestFullScreen || //FireFox
        element.mozRequestFullScreen || //Chrome等
        element.msRequestFullScreen; //IE11
    if (requestMethod) {
        requestMethod.call(element);
    } else if (typeof window.ActiveXObject !== "undefined") { //for Internet Explorer
        var wscript = new ActiveXObject("WScript.Shell");
        if (wscript !== null) {
            wscript.SendKeys("{F11}");
        }
    }
}