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
        List<Transaction> collect = this.transactions.stream()
                .filter(t -> t.getTransactionStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return collect;
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
        return this.transactions.stream()
                .filter(t -> t.getSender().equals(sender))
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return this.transactions.iterator();
    }
}
