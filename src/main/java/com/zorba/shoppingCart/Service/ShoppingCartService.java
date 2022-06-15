package com.zorba.shoppingCart.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zorba.shoppingCart.DTO.CustomerDTO;
import com.zorba.shoppingCart.DTO.ItemsDTO;
import com.zorba.shoppingCart.entity.Customer;
import com.zorba.shoppingCart.entity.Items;
import com.zorba.shoppingCart.repository.ShoppingCartRepository;

@Service

public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public Boolean saveRecords(List<CustomerDTO> customerDTOList) {
        for (CustomerDTO customerDTO : customerDTOList) {
            Customer customer = new Customer();
            customer.setCustName(customerDTO.getCustName());
            customer.setMobileNumber(customerDTO.getMobNumber());
            customer.setCountry(customerDTO.getCountry());

            // create list of ItemsDTO to save the item list in the CustomerDTO
            List<ItemsDTO> itemsDTOList = customerDTO.getItems(); // Items list retrieved from ItemDTO
            for (ItemsDTO iterating : itemsDTOList) { // iterate through itemDTO list
                Items items = new Items(); // create Item object
                items.setName(iterating.getName()); // save item name
                items.setQuantity(iterating.getQuantity());
                //foodItems.add(items);
                customer.addItems(items); // invoke addItems method in Customer Entity class
            }
            //customer.setItems(foodItems);

            shoppingCartRepository.save(customer); // saving the entire CustomerDTO object in to the Customer object
        }
        return true;
    }


    public Customer fetchItemsSelectedByCustomer(Long custId) {
        Customer customer = new Customer();
        return customer;
    }

    public Boolean deleteCustomerRecords(Long custId) {
        return true;
    }
}


