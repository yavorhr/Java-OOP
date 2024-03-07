package invoker;

import command.Command;

public class FileInvoker {
  public Command command;

  public FileInvoker(Command command) {
    this.command = command;
  }

  public void execute() {
    this.command.execute();
  }
}
