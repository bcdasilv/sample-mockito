package manualmock;

import basecode.Customer;
import basecode.FinalInvoiceStep;
import basecode.Invoice;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class FinalInvoiceStepTestWithManualMock {
    private FinalInvoiceStep finalInvoiceStep = null;
    private Customer customer = null;
    private Invoice invoice = null;
    private ManualMockPrinterService dummyPrinterService = null;
    private ManualMockEmailService dummyEmailService = null;

    @Before
    public void beforeEachTest() {
        dummyPrinterService = new ManualMockPrinterService();
        dummyEmailService = new ManualMockEmailService();
        customer = new Customer("TestingCustomer", "testing@gmail.com");
        finalInvoiceStep = new FinalInvoiceStep(dummyPrinterService, dummyEmailService);
        invoice = new Invoice();
    }

    @Test
    public void normalCustomer() {
        customer.wantsEmail(true);
        finalInvoiceStep.handleInvoice(invoice, customer);
        assertFalse("Nothing should be printed",dummyPrinterService.anInvoiceWasPrinted());
        assertTrue("Invoice was sent by email", dummyEmailService.anInvoiceWasEmailed());
    }

    @Test
    public void customerWithPrintedInvoice() {
        customer.wantsEmail(false);
        finalInvoiceStep.handleInvoice(invoice, customer);
        assertTrue("Invoice was printed",dummyPrinterService.anInvoiceWasPrinted());
    }
}
