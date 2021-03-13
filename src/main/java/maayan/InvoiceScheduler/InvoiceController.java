package maayan.InvoiceScheduler;

import maayan.InvoiceScheduler.Service.InvoiceService;
import maayan.InvoiceScheduler.Service.RiskService;
import maayan.InvoiceScheduler.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService service;
    @Autowired
    private RiskService risk;

    @GetMapping("/invoices/{id}")
    Invoice getInvoice(@PathVariable("id") int invoice_id){
        return service.findByInvoiceId(invoice_id);
    }

    @PostMapping("/invoices")
    int generateInvoice(@RequestBody InvoiceRequestBody body){
        float requested_amount = body.amount;
        if (risk.validateRisk(requested_amount)) {
            return service.generateAndInsertNewInvoice(requested_amount);
        } else {
            //prohibited request: user risk score denies invoices of high amount
            return -1;
        }
    }

    @PutMapping("/invoices/{id}")
    void scheduleInvoice(@PathVariable("id") int invoice_id, @RequestBody InvoiceRequestBody body){
        // consider moving this logic to invoiceService
        if (service.findByInvoiceId(invoice_id).getDueDate() <= 0) {
            service.updateInvoiceDueDate(invoice_id, body.due_date);
        }
        else {
            //prohibited request: invoice is already scheduled!
            //in order to reschedule invoice cancel it and schedule again
        }
    }

    @PutMapping("/invoices/{id}/unschedule")
    void cancelScheduleForInvoice(@PathVariable("id") int invoice_id){
        service.updateInvoiceDueDate(invoice_id, 0);
    }

    @GetMapping("/invoices/{id}/info")
    String getInvoiceInfo(@PathVariable("id") int invoice_id){
        return service.findByInvoiceId(invoice_id).InvoiceBasicInfo();
    }

}
