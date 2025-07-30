package com.example.invoicejet.service;

import com.example.invoicejet.model.Invoice;
import com.example.invoicejet.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> optional = invoiceRepository.findById(id);
        return optional.orElse(null);
    }

    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
