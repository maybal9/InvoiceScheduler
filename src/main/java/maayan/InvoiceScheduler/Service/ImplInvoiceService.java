package maayan.InvoiceScheduler.Service;

import maayan.InvoiceScheduler.model.Invoice;
import maayan.InvoiceScheduler.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplInvoiceService implements InvoiceService{

    @Autowired
    private InvoiceRepository repo;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Override
    public Invoice findByInvoiceId(int invoice_id) {
        return repo.findByInvoiceId(invoice_id);
    }

    @Override
    public void updateInvoiceDueDate(int invoice_id, int due_date) {
        Invoice invoice = findByInvoiceId(invoice_id);
        invoice.updateDueDate(due_date);
        repo.save(invoice);
    }

    @Override
    public int generateAndInsertNewInvoice(float amount) {
        Invoice new_invoice = new Invoice(amount);
        int new_id = sequenceGenerator.generateSequence(Invoice.SEQUENCE_NAME);
        new_invoice.setInvoiceId(new_id);
        repo.insert(new_invoice);
        return new_id;
    }
}
