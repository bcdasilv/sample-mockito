package manualmock;

import basecode.EmailService;
import basecode.Invoice;

public class ManualMockEmailService implements EmailService{

    private boolean anInvoiceWasEmailed = false;

    @Override
    public void sendInvoice(Invoice invoice, String email) {
        anInvoiceWasEmailed = true;
    }

    public boolean anInvoiceWasEmailed() {
        return anInvoiceWasEmailed;
    }
}
