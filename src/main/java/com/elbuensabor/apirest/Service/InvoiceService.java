package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Invoice;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id) throws MiException;
    Invoice createInvoice(Invoice invoice) throws MiException;
    Invoice updateInvoice(Long id, Invoice invoice) throws MiException;
    void deleteInvoice(Long id) throws MiException;
}
