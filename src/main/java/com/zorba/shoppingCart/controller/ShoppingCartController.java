package com.zorba.shoppingCart.controller;
import java.util.List;

import com.zorba.shoppingCart.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zorba.shoppingCart.DTO.CustomerDTO;
import com.zorba.shoppingCart.Service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")




public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingcartService;


    @PostMapping("/saveRecords")
    public Boolean saveRecords(@RequestBody List<CustomerDTO> customerDetails) {
        return shoppingcartService.saveRecords(customerDetails);
    }

    @GetMapping(value = "/fetchRecords", produces=MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO fetchRecords(@RequestParam(name="custId") Long custId) {
        Customer cust = shoppingcartService.fetchItemsSelectedByCustomer(custId);
        CustomerDTO customerDTO = new CustomerDTO();
        return customerDTO;
    }

    @DeleteMapping(value="/deleteRecords")
    public Boolean deleteRecords(@RequestParam(name="custId") Long custId) {
        return shoppingcartService.deleteCustomerRecords(custId);
    }

}

