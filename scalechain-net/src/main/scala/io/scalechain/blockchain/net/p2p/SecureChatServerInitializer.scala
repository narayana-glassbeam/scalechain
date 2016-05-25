package io.scalechain.blockchain.net

import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelPipeline
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.DelimiterBasedFrameDecoder
import io.netty.handler.codec.Delimiters
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.ssl.SslContext

/**
  * Creates a newly configured {@link ChannelPipeline} for a new channel.
  */
class SecureChatServerInitializer(sslCtx : SslContext) extends ChannelInitializer[SocketChannel] {

  override def initChannel(ch : SocketChannel) : Unit = {
    val pipeline : ChannelPipeline = ch.pipeline()

    // Add SSL handler first to encrypt and decrypt everything.
    // In this example, we use a bogus certificate in the server side
    // and accept any invalid certificates in the client side.
    // You will need something more complicated to identify both
    // and server in the real world.
    pipeline.addLast(sslCtx.newHandler(ch.alloc()))

    // On top of the SSL handler, add the text line codec.
    pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter(): _*))
    pipeline.addLast(new StringDecoder())
    pipeline.addLast(new StringEncoder())

    // and then business logic.
    pipeline.addLast(new SecureChatServerHandler())
  }
}
