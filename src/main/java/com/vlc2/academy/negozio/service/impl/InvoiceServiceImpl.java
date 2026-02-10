package com.vlc2.academy.negozio.service.impl;

import com.vlc2.academy.negozio.dto.invoice.InvoiceCreateDTO;
import com.vlc2.academy.negozio.dto.invoice.InvoiceReadDTO;
import com.vlc2.academy.negozio.dto.product.ProductReadDTO;
import com.vlc2.academy.negozio.entity.Customer;
import com.vlc2.academy.negozio.entity.Invoice;
import com.vlc2.academy.negozio.entity.Product;
import com.vlc2.academy.negozio.exceptions.CustomerNotFound;
import com.vlc2.academy.negozio.exceptions.InvoiceNotFound;
import com.vlc2.academy.negozio.exceptions.OutOfStock;
import com.vlc2.academy.negozio.exceptions.ProductNotFound;
import com.vlc2.academy.negozio.mapper.InvoiceMapper;
import com.vlc2.academy.negozio.repository.CustomerRepository;
import com.vlc2.academy.negozio.repository.InvoiceRepository;
import com.vlc2.academy.negozio.repository.ProductRepository;
import com.vlc2.academy.negozio.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    CustomerRepository customerRepository;
    ProductRepository productRepository;
    InvoiceRepository invoiceRepository;
    InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl (CustomerRepository customerRepository, ProductRepository productRepository, InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper){
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }


    @Override
    public void executeTransaction(InvoiceCreateDTO invoiceCreateDTO) {

        Integer customerId = invoiceCreateDTO.getCustomerId();
        Integer productId = invoiceCreateDTO.getProductId();
        Integer quantitySold = invoiceCreateDTO.getQuantity();


        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFound(String.format("There isn't any customer with id = %d",customerId)));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFound(String.format("There isn't any product with id = %d",productId)));

        Integer quantityLeft = product.getQuantity();

        if(quantitySold > quantityLeft){
            throw new OutOfStock(String.format("You can't purchase %d %s because there's only %d left",
                    quantitySold,
                    product.getName(),
                    quantityLeft));
        }



        Invoice invoice = new Invoice(quantitySold, customer, product);
        product.setQuantity(quantityLeft - quantitySold);
        product.setQuantitySold(product.getQuantitySold() + quantitySold);
        product.addInvoice(invoice);
        customer.addInvoice(invoice);

        productRepository.save(product);
        invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceReadDTO getInvoiceById(Integer id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFound(String.format("There isn't any invoice with id = %d",id)));
        InvoiceReadDTO invoiceReadDTO = invoiceMapper.toDTO(invoice);
        return invoiceReadDTO;
    }

    @Override
    public List<InvoiceReadDTO> getInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<InvoiceReadDTO> invoicesDTO = invoices.stream()
                .map(invoice -> invoiceMapper.toDTO(invoice))
                .toList();
        return invoicesDTO;
    }
}
