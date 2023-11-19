package top.yumbo.util.chrome;


import top.yumbo.util.cmd.CommandUtil;
import top.yumbo.util.music.MusicEnum;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class ChromeUtil {

    public static int port = 9999;

    public static void callChromeOpenQrCode() {
        try {
            //用浏览器打开二维码页面
            CommandUtil.executeCmd("start chrome.exe " + MusicEnum.BASE_URL_163Music + "/qrlogin.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getCookie() throws IOException, InterruptedException {
        return getCookie("localhost", port);
    }

    public static String getCookie(String hostname, int port) throws IOException, InterruptedException {
        callChromeOpenQrCode();
        if (port == 0) port = ChromeUtil.port;
        // 监听扫描的二维码的消息
        return startServerReturnCookie(port);
    }

    public static String startServerReturnCookie(int port) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        InetSocketAddress socketAddress = new InetSocketAddress(port);
        ServerSocketChannel serverSocketChannel = socketChannel.bind(socketAddress);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动完成");
        for (; ; ) {
            int readChannelNums = selector.select();
            if (readChannelNums == 0) continue;
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    try {
                        SocketChannel channel = serverSocketChannel.accept();
                        //设置为非阻塞
                        channel.configureBlocking(false);
                        //放入selector选择器中，并让选择器监听该通道读事件
                        channel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024 * 16));
                        System.out.println(channel.getRemoteAddress() + "  正在读取cookie！");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (selectionKey.isReadable()) {
                    try {
                        return listenAndParseCookie(selector, selectionKey);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static String listenAndParseCookie(Selector selector, SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuf = ByteBuffer.allocate(1024);
        StringBuilder msg = new StringBuilder();
        while (channel.read(byteBuf) > 0) {
            byteBuf.flip();
            msg.append(StandardCharsets.UTF_8.decode(byteBuf));
            byteBuf.flip();
        }
        channel.register(selector, SelectionKey.OP_READ);
        if (msg.length() > 0) {
            String cookieStr = msg.toString().split("HTTP/1")[0].split("cookie=")[1];
            String cookie = URLDecoder.decode(cookieStr,StandardCharsets.UTF_8);
            return cookie;
        }
        return "";
    }


}
