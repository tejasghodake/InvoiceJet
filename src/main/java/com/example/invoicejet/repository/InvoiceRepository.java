package com.example.invoicejet.repository;

import com.example.invoicejet.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // Additional query methods (if needed) can be added here
}
