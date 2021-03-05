package com.cloudaidatastream.shoppingmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudaidatastream.shoppingmart.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
