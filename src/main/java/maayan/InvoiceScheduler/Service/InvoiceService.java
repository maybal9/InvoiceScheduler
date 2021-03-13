package maayan.InvoiceScheduler.Service;

import maayan.InvoiceScheduler.model.Invoice;

// defines operations set on Invoice Repository
// creates an additional level of abstraction
public interface InvoiceService {

    public Invoice findByInvoiceId(int invoice_id);
    public void updateInvoiceDueDate(int invoice_id, int due_date);
    public int generateAndInsertNewInvoice(float amount);
}
