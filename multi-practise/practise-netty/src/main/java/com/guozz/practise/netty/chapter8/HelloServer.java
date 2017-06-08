package com.guozz.practise.netty.chapter8;

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
            	//return Channels.pipeline(new ObjectDecoder(ClassResolvers.cacheDisabled(this.getClass().getClassLoader())),new ObjectServerHandler());
            	//这里需要注意，注册到Server的Handler是有顺序的，如果你颠倒一下注册顺序结果就是，会先进入我们自己的业务，再进行解码。这自然是不行的，会强转失败。至此，你应该会用Netty传递对象了吧。
            	return Channels.pipeline(new ObjectServerHandler(),new ObjectDecoder(ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
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
