import java.util.ArrayList;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious) */
public class CompliantNode implements Node {

    private boolean[] followees;
    private Set<Transaction> pendingTransactions;

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
    }

    /** {@code followees[i]} is true if and only if this node follows node {@code i} */
    public void setFollowees(boolean[] followees) {
        this.followees = followees;
    }

    /** initialize proposal list of transactions */
    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    /**
     * @return proposals to send to my followers. REMEMBER: After final round, behavior of
     *         {@code getProposals} changes and it should return the transactions upon which
     *         consensus has been reached.
     */
    public Set<Transaction> sendToFollowers() {
        return this.pendingTransactions;
    }

    /** receive candidates from other nodes. */
    public void receiveFromFollowees(Set<Candidate> candidates) {
        for (Candidate c : candidates) {
            if (isMyFollowee(c)) {
                this.pendingTransactions.add(c.tx);
            }
        }
    }

    /**
     * @param c
     * @return
     */
    private boolean isMyFollowee(Candidate c) {
        return followees[c.sender];
    }
}
