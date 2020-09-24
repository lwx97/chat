var websocket = null;
var status = null;
function onOpenWebSocket(username,callback) {
    //判断是否取昵称
    if(username == null || username == ""){
        alert("请填写昵称！");
        return;
    }
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://127.0.0.1:8012/webSocket?username="+ username);
    } else {
        alert('当前浏览器 Not support webSocket')
    }

    /**
     * 连接发生错误的回调方法
     */
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误",callback);
    };

    /**
     * 连接成功建立的回调方法
     */
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功",callback);
        status = 'success';
    }

    /**
     * 接收到消息的回调方法
     * @param event
     */
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    /**
     * 连接关闭的回调方法
     */
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭",callback);
    }

    /**
     * 监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
     */
    window.onbeforeunload = function () {
        closeWebSocket();
    }
}



/**
 * 将消息显示在网页上
 * @param innerHTML
 */
function setMessageInnerHTML(innerHTML,callback) {
    if(callback != null) {
        callback(status,innerHTML);
    }
}

/**
 * 关闭WebSocket连接
 */
function closeWebSocket() {
    websocket.close();
}

/**
 * 发送消息
 */
function send(message) {
    websocket.send(message);
}