package manualmock;

import basecode.Invoice;
import basecode.PrinterService;

public class ManualMockPrinterService implements PrinterService {

    private boolean anInvoiceWasPrinted = false;

    @Override
    public boolean isPrinterConfigured() {
        return true;
    }

    @Override
    public void printInvoice(Invoice invoice) {
        anInvoiceWasPrinted = true;
    }

    public boolean anInvoiceWasPrinted() {
        return anInvoiceWasPrinted;
    }
}
