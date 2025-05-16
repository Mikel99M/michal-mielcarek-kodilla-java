package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product productOne = new Product("Iphone 28");
        Product productTwo = new Product("Ipad");
        Product productThree = new Product("Tablet");

        productDao.save(productOne);
        productDao.save(productTwo);
        productDao.save(productThree);

        Item itemOne = new Item(productOne, new BigDecimal("10000"), 10, new BigDecimal("123"));
        Item itemTwo = new Item(productTwo, new BigDecimal("2999"), 20, new BigDecimal("95"));
        Item itemThree = new Item(productThree, new BigDecimal("799"), 30, new BigDecimal("113"));
        Item itemFour = new Item(productOne, new BigDecimal("5000"), 11, new BigDecimal("123"));

        productOne.getItems().add(itemOne);
        productTwo.getItems().add(itemTwo);
        productThree.getItems().add(itemThree);
        productOne.getItems().add(itemFour);
        productTwo.getItems().add(itemFour);
        productThree.getItems().add(itemFour);

        Invoice invoice = new Invoice("9214");

        invoice.getItems().add(itemOne);
        invoice.getItems().add(itemTwo);
        invoice.getItems().add(itemThree);
        invoice.getItems().add(itemFour);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        productDao.save(productOne);
        int productOneId = productOne.getId();
        itemDao.save(itemOne);
        int itemOneId = itemOne.getId();

        itemOne.setInvoice(invoice);
        itemTwo.setInvoice(invoice);
        itemThree.setInvoice(invoice);
        itemFour.setInvoice(invoice);

        //Then
        assertNotEquals(0, invoiceId);
        assertNotEquals(0, productOneId);
        assertNotEquals(0, itemOneId);

        //CleanUp
        try {
            itemDao.deleteById(itemOneId);
            itemDao.deleteById(itemTwo.getId());
            itemDao.deleteById(itemThree.getId());
            itemDao.deleteById(itemFour.getId());
        } catch (Exception e) {
            //do nothing
        }
    }
}
