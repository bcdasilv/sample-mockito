package withmockito;

import basecode.Customer;
import basecode.FinalInvoiceStep;
import basecode.Invoice;
import basecode.PrinterService;
import basecode.EmailService;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

public class FinalInvoiceStepTestMocked {
    private FinalInvoiceStep finalInvoiceStep = null;
    private Customer customer = null;
    private Invoice invoice = null;
    private PrinterService printerService = null;
    private EmailService emailService =null;

    @Before
    public void beforeEachTest() {
        printerService = Mockito.mock(PrinterService.class);
        emailService = Mockito.mock(EmailService.class);
        customer = new Customer("TestingCustomer", "testing@gmail.com");
        finalInvoiceStep = new FinalInvoiceStep(printerService, emailService);
        invoice = new Invoice();
    }

    @Test
    public void normalCustomer() {
        customer.wantsEmail(true);
        finalInvoiceStep.handleInvoice(invoice, customer);
        //Nothing should be printed
        Mockito.verifyZeroInteractions(printerService);
        //Something must be emailed
        Mockito.verify(emailService).sendInvoice(invoice, customer.getEmail());
    }

    @Test
    public void customerWithPrintedInvoice() {
        customer.wantsEmail(false);
        finalInvoiceStep.handleInvoice(invoice, customer);
        //Nothing should be  emailed
        Mockito.verifyZeroInteractions(emailService);
        //The invoice must be printed
        Mockito.verify(printerService).printInvoice(invoice);
    }
}
