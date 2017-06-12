package com.guozz.practise.netty.chapter10;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-6
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public class HelloClient {

    public static void main(String args[]) {
        // Client服务启动器
        ClientBootstrap bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        // 设置一个处理服务端消息和各种消息事件的类(Handler)
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                //return Channels.pipeline(new HelloClientHandler());
            	  return Channels.pipeline(new ObjectEncoder(),
                          new ObjectClientHandler());
            }
        });
        // 连接到本地的8000端口的服务端
        bootstrap.connect(new InetSocketAddress(
                "127.0.0.1", 8000));
    }

    private static class ObjectClientHandler extends SimpleChannelHandler {

        /**
         * 当绑定到服务端的时候触发，打印"Hello world, I'm client."
         *
         * @alia OneCoder
         * @author lihzh
         */
        @Override
        public void channelConnected(ChannelHandlerContext ctx,
                                     ChannelStateEvent e) {
            sendObject(e.getChannel());
            
        }

		private void sendObject(Channel channel) {
			Command command = new Command();
			command.setActionName("Hello action.");
			Command commandOne = new Command();
			commandOne.setActionName("Hello action. One");
			Command command2 = new Command();
			command2.setActionName("Hello action. Two");
			channel.write(command2);
			channel.write(command);
			channel.write(commandOne);
		}
    }
}
