package maayan.InvoiceScheduler;

import maayan.InvoiceScheduler.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, Integer> {
    public Invoice findByInvoiceId(int invoice_id);
}

