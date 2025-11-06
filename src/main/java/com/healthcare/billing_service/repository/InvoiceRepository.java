package com.healthcare.billing_service.repository;

import com.healthcare.billing_service.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
