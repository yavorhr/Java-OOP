public interface Transaction {

  int getId();
  TransactionStatus getTransactionStatus();
  void setTransactionStatus(TransactionStatus status);
  double getAmount();
  String getSender();
  String getReceiver();
}
