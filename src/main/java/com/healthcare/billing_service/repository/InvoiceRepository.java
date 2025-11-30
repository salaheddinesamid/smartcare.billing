package com.healthcare.billing_service.repository;

import com.healthcare.billing_service.model.Invoice;
import com.healthcare.billing_service.model.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    List<Invoice> findAllByStatus(InvoiceStatus invoiceStatus);
}
