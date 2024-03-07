import command.CloseFileCommand;
import command.OpenFileCommand;
import command.WriteFileCommand;
import factory.FileSystemReceiverUtil;
import invoker.FileInvoker;
import receiver.FileSystemReceiver;

public class Main {
  public static void main(String[] args) {
    //Creating the receiver object
    FileSystemReceiver fileSystReceiver = FileSystemReceiverUtil.getUnderlyingFileSystem();

    //creating command and associating with receiver
    OpenFileCommand openFileCommand = new OpenFileCommand(fileSystReceiver);

    //Creating invoker and associating with Command
    FileInvoker file = new FileInvoker(openFileCommand);

    //perform action on invoker object
    file.execute();

    WriteFileCommand writeFileCommand = new WriteFileCommand(fileSystReceiver);

    file = new FileInvoker(writeFileCommand);
    file.execute();

    CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystReceiver);
    file = new FileInvoker(closeFileCommand);
    file.execute();
  }
}
