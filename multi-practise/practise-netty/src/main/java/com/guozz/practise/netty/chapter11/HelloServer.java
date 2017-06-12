package com.guozz.practise.netty.chapter11;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-6
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */
public class HelloServer {
    public static void main(String [] args){
        // Server服务启动器
        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        // 设置一个处理客户端消息和各种消息事件的类(Handler)
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline()
                    throws Exception {
            	return Channels.pipeline(new ObjectDecoder(ClassResolvers.cacheDisabled(this.getClass().getClassLoader())),new ObjectServerHandler());
            	
            }
        });
        // 开放8000端口供客户端访问。
        bootstrap.bind(new InetSocketAddress(8000));
    }
    
    /**
     * 对象传递服务端代码
     * @author Administrator
     *
     */
    private static class ObjectServerHandler extends SimpleChannelHandler {
    	/**
    	 * 当接受到消息的时候触发
    	 */
        @Override
        public void messageReceived(
             ChannelHandlerContext ctx, MessageEvent e) {
        	 Command command = (Command) e.getMessage();
             // 打印看看是不是我们刚才传过来的那个
             System.out.println(command.getActionName());
        }
    }
}
