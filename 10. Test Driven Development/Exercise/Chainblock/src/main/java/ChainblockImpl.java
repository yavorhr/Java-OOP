import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private List<Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new ArrayList<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (this.contains(transaction.getId())) {
            throw new IllegalArgumentException();
        }
        this.transactions.add(transaction);
    }

    public boolean contains(Transaction transaction) {
        for (Transaction trans : this.transactions) {
            if (trans.getId() == transaction.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(int id) {
        for (Transaction trans : this.transactions) {
            if (trans.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }

        Transaction transactionById = this.getById(id);
        transactionById.setTransactionStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }

        Transaction byId = this.getById(id);

        this.transactions.remove(byId);
    }

    public Transaction getById(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }

        return this.transactions.stream()
                .filter(t -> t.getId() == id)
                .collect(Collectors.toList())
                .stream()
                .findFirst()
                .orElse(null);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = this.transactions.stream()
                .filter(t -> t.getTransactionStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> senders = this.transactions.stream()
                .filter(t -> t.getTransactionStatus().equals(status))
                .map(Transaction::getSender)
                .collect(Collectors.toList());

        if (senders.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> senders = this.transactions.stream()
                .filter(t -> t.getTransactionStatus().equals(status))
                .map(Transaction::getReceiver)
                .collect(Collectors.toList());

        if (senders.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return senders;
    }


    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactions.stream()
                .sorted((t1, t2) -> {
                    int result = Double.compare(t2.getAmount(), t1.getAmount());
                    if (result == 0) {
                        result = Integer.compare(t1.getId(), t2.getId());
                    }
                    return result;
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {

        List<Transaction> transactionsBySender = this.transactions.stream()
                .filter(t -> t.getSender().equals(sender))
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());

        if (transactionsBySender.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactionsBySender;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactionsByReceiver = this.transactions.stream()
                .filter(t -> t.getReceiver().equals(receiver))
                .sorted((t1, t2) -> {
                    int result = Double.compare(t2.getAmount(), t1.getAmount());
                    if (result == 0) {
                        result = Integer.compare(t1.getId(), t2.getId());
                    }
                    return result;
                })
                .collect(Collectors.toList());

        if (transactionsByReceiver.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactionsByReceiver;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = this.transactions.stream()
                .filter(t -> t.getTransactionStatus().equals(status) && t.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = this.transactions.stream()
                .filter(t -> t.getSender().equals(sender) && t.getAmount() >= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = this.transactions.stream()
                .filter(t -> t.getReceiver().equals(receiver) && t.getAmount() >= lo && t.getAmount() < hi)
                .sorted((t1, t2) -> {
                    int result = Double.compare(t2.getAmount(), t1.getAmount());
                    if (result == 0) {
                        result = Integer.compare(t1.getId(), t2.getId());
                    }
                    return result;
                })
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = this.transactions.stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterator<Transaction> iterator() {
        return this.transactions.iterator();
    }
}
