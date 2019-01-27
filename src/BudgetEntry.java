import java.util.Date;
import java.math.BigDecimal;

public class BudgetEntry {
    private BigDecimal amount;
    private String entryName;
    private Date entryDate;


    public BigDecimal getAmount() {
        return amount;
    }

    public String getEntryName() {
        return entryName;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "BudgetEntry{" +
                "amount=" + amount +
                ", entryName='" + entryName + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }


}
