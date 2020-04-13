package integrationtesting;

import basecode.Customer;
import basecode.FinalInvoiceStep;
import basecode.Invoice;

import org.junit.Test;
import org.junit.Before;


public class FinalInvoiceStepTest {
    private FinalInvoiceStep finalInvoiceStep = null;
    private Customer customer = null;
    private Invoice invoice = null;

    @Before
    public void beforeEachTest() {
        customer = new Customer("TestingCustomer", "testing@gmail.com");

        //Here you would have to instantiate the FinalInvoiceStep with real [printing and emailing] services
        //finalInvoiceStep = new FinalInvoiceStep(Env.PrinterServiceLocator(), Env.EmailServiceLocator());
        //finalInvoiceStep = new FinalInvoiceStep(PrinterService.getInstance(), EmailService.getInstance());

        invoice = new Invoice();
    }

    @Test
    public void normalCustomer() {
        customer.wantsEmail(true);
        finalInvoiceStep.handleInvoice(invoice, customer);
    }

    @Test
    public void customerWithPrintedInvoice() {
        customer.wantsEmail(false);
        finalInvoiceStep.handleInvoice(invoice, customer);
    }
}