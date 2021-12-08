package grpc.ca.ChatSupport;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ChatSupport.proto")
public final class chatSupportGrpc {

  private chatSupportGrpc() {}

  public static final String SERVICE_NAME = "chatSupport";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ca.ChatSupport.HelloRequest4,
      grpc.ca.ChatSupport.HelloReply4> getGetChatSupportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChatSupport",
      requestType = grpc.ca.ChatSupport.HelloRequest4.class,
      responseType = grpc.ca.ChatSupport.HelloReply4.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.ca.ChatSupport.HelloRequest4,
      grpc.ca.ChatSupport.HelloReply4> getGetChatSupportMethod() {
    io.grpc.MethodDescriptor<grpc.ca.ChatSupport.HelloRequest4, grpc.ca.ChatSupport.HelloReply4> getGetChatSupportMethod;
    if ((getGetChatSupportMethod = chatSupportGrpc.getGetChatSupportMethod) == null) {
      synchronized (chatSupportGrpc.class) {
        if ((getGetChatSupportMethod = chatSupportGrpc.getGetChatSupportMethod) == null) {
          chatSupportGrpc.getGetChatSupportMethod = getGetChatSupportMethod = 
              io.grpc.MethodDescriptor.<grpc.ca.ChatSupport.HelloRequest4, grpc.ca.ChatSupport.HelloReply4>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "chatSupport", "GetChatSupport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.ChatSupport.HelloRequest4.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ca.ChatSupport.HelloReply4.getDefaultInstance()))
                  .setSchemaDescriptor(new chatSupportMethodDescriptorSupplier("GetChatSupport"))
                  .build();
          }
        }
     }
     return getGetChatSupportMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static chatSupportStub newStub(io.grpc.Channel channel) {
    return new chatSupportStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static chatSupportBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new chatSupportBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static chatSupportFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new chatSupportFutureStub(channel);
  }

  /**
   */
  public static abstract class chatSupportImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.ca.ChatSupport.HelloRequest4> getChatSupport(
        io.grpc.stub.StreamObserver<grpc.ca.ChatSupport.HelloReply4> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetChatSupportMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetChatSupportMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.ca.ChatSupport.HelloRequest4,
                grpc.ca.ChatSupport.HelloReply4>(
                  this, METHODID_GET_CHAT_SUPPORT)))
          .build();
    }
  }

  /**
   */
  public static final class chatSupportStub extends io.grpc.stub.AbstractStub<chatSupportStub> {
    private chatSupportStub(io.grpc.Channel channel) {
      super(channel);
    }

    private chatSupportStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected chatSupportStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new chatSupportStub(channel, callOptions);
    }

    /**
     * <pre>
     *bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.ca.ChatSupport.HelloRequest4> getChatSupport(
        io.grpc.stub.StreamObserver<grpc.ca.ChatSupport.HelloReply4> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetChatSupportMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class chatSupportBlockingStub extends io.grpc.stub.AbstractStub<chatSupportBlockingStub> {
    private chatSupportBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private chatSupportBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected chatSupportBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new chatSupportBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class chatSupportFutureStub extends io.grpc.stub.AbstractStub<chatSupportFutureStub> {
    private chatSupportFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private chatSupportFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected chatSupportFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new chatSupportFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_CHAT_SUPPORT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final chatSupportImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(chatSupportImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CHAT_SUPPORT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getChatSupport(
              (io.grpc.stub.StreamObserver<grpc.ca.ChatSupport.HelloReply4>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class chatSupportBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    chatSupportBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ca.ChatSupport.NewServiceImpl3.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("chatSupport");
    }
  }

  private static final class chatSupportFileDescriptorSupplier
      extends chatSupportBaseDescriptorSupplier {
    chatSupportFileDescriptorSupplier() {}
  }

  private static final class chatSupportMethodDescriptorSupplier
      extends chatSupportBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    chatSupportMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (chatSupportGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new chatSupportFileDescriptorSupplier())
              .addMethod(getGetChatSupportMethod())
              .build();
        }
      }
    }
    return result;
  }
}
