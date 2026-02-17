package com.vlc2.academy.negozio.exceptions;

import com.vlc2.academy.negozio.exceptions.customExceptions.CustomerNotFound;
import com.vlc2.academy.negozio.exceptions.customExceptions.InvoiceNotFound;
import com.vlc2.academy.negozio.exceptions.customExceptions.OutOfStock;
import com.vlc2.academy.negozio.exceptions.customExceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleCustomerNotFound (CustomerNotFound exc){
        return new ErrorResponse("CUSTOMER_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleProductNotFound (ProductNotFound exc){
        return new ErrorResponse("PRODUCT_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(InvoiceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleInvoiceNotFound (InvoiceNotFound exc){
        return new ErrorResponse("INVOICE_NOT_FOUND",exc.getMessage());
    }

    @ExceptionHandler(OutOfStock.class)
    @ResponseStatus(HttpStatus.CONTENT_TOO_LARGE)
    @ResponseBody
    public ErrorResponse handleOutOfStock (ProductNotFound exc){
        return new ErrorResponse("OUT_OF_STOCK",exc.getMessage());
    }

}
