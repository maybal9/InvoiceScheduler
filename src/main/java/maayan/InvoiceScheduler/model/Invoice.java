package maayan.InvoiceScheduler.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

@Document(collection = "invoices")
public class Invoice {

    @Transient
    public static final String SEQUENCE_NAME = "invoices_sequence";

    @Id
    public int invoiceId;
    private float amount;
    private int creation_date;
    private String description;
    private int due_date;
    private String company_name;
    private String customer_email;

    public Invoice(int invoice_id, float amount, int create_date, String describe, int due_date, String comp_name, String customer_email){
        this.invoiceId = invoice_id;
        this.amount = amount;
        this.creation_date = create_date;
        this.description = describe;
        this.due_date = due_date;
        this.company_name = comp_name;
        this.customer_email = customer_email;
    }

    @PersistenceConstructor
    public Invoice(float amount){
        this(0, amount, 0, "", 0, "", "");
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getDueDate() {
        return due_date;
    }

    public void setInvoiceId(int id){
        this.invoiceId = id;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void updateDueDate(int due_date) {
        this.due_date = due_date;
    }

    public String InvoiceBasicInfo(){
        String scheduled_str = this.due_date != 0 ? "is scheduled to date: " + this.due_date : "is not scheduled to be paid";
        return String.format("Invoice id: %d, amount: %f, " + scheduled_str, this.invoiceId, this.amount);
    }
}
