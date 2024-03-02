public interface Transaction {

  int getId();
  TransactionStatus getTransactionStatus();
  void setTransactionStatus(TransactionStatus status);
}