package org.jpstale.server.login.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.jpstale.server.login.service.AccountLoginServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyLoginServer {

    private static final Logger log = LoggerFactory.getLogger(NettyLoginServer.class);

    @Value("${pt.login.port:8484}")
    private int port;

    @Bean
    public ApplicationRunner nettyLoginServerRunner(PtLoginHandler ptLoginHandler) {
        return args -> {
            NioEventLoopGroup boss = new NioEventLoopGroup(1);
            NioEventLoopGroup worker = new NioEventLoopGroup();
            try {
                new ServerBootstrap()
                    .group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline()
                                .addLast(new PtFrameDecoder())
                                .addLast(ptLoginHandler);
                        }
                    })
                    .bind(port)
                    .sync();
                log.info("PT Login Server (Netty) listening on port {}", port);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        };
    }
}
