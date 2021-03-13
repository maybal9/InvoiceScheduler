package maayan.InvoiceScheduler;

import org.springframework.context.annotation.Bean;

import javax.persistence.criteria.CriteriaBuilder;

public class InvoiceRequestBody {
    float amount;
    int due_date;

    public InvoiceRequestBody(float amount, int due_date){
        this.amount = amount;
        this.due_date = due_date;
    }

    public InvoiceRequestBody(float amount){
        this(amount,0);
    }

    public InvoiceRequestBody(int due_date){
        this(0,due_date);
    }

    public float getAmount() {
        return amount;
    }

    public int getDue_date() {
        return due_date;
    }
}


