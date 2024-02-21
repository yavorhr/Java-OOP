package interfaces;

public interface AppenderFactory {
  Appender produce(String appenderType, Layout layout);
}
