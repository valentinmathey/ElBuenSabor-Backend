package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Invoice;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) throws MiException {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new MiException("Invoice not found with id: " + id));
    }

    @Override
    @Transactional
    public Invoice createInvoice(Invoice invoice) throws MiException {
        try {
            return invoiceRepository.save(invoice);
        } catch (Exception e) {
            throw new MiException("Error creating invoice!");
        }
    }

    @Override
    @Transactional
    public Invoice updateInvoice(Long id, Invoice invoice) throws MiException {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new MiException("Invoice not found with id: " + id));

        existingInvoice.setDate(invoice.getDate());
        existingInvoice.setNumber(invoice.getNumber());
        existingInvoice.setDiscount(invoice.getDiscount());
        existingInvoice.setPaymentMethod(invoice.getPaymentMethod());
        existingInvoice.setTotal(invoice.getTotal());
        existingInvoice.setOrder(invoice.getOrder());

        try {
            return invoiceRepository.save(existingInvoice);
        } catch (Exception e) {
            throw new MiException("Error updating invoice!");
        }
    }

    @Override
    @Transactional
    public void deleteInvoice(Long id) throws MiException {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new MiException("Invoice not found with id: " + id));

        try {
            invoiceRepository.delete(existingInvoice);
        } catch (Exception e) {
            throw new MiException("Error deleting invoice!");
        }
    }
}
