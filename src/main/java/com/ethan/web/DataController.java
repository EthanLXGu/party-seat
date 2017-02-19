package com.ethan.web;

import com.ethan.dao.CustomerRepository;
import com.ethan.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lingxingu on 2017/2/18.
 */
@RestController
public class DataController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    @RequestMapping("/save")
    public String process() {
        customerRepository.save(new Customer("Test1", Integer.toUnsignedLong(6666)));
        customerRepository.save(new Customer("Test2", Integer.toUnsignedLong(7777)));
        customerRepository.save(new Customer("Test3", Integer.toUnsignedLong(8888)));
        customerRepository.save(new Customer("Test4", Integer.toUnsignedLong(9999)));
        return "Done";
    }

    @RequestMapping(value = "/users")
    public String findAll() {
        String result = "<html>";
        for (Customer customer : customerRepository.findAll()) {
            result += "<div>" + customer.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyname")
    public List<Customer> findUserByUserName(@RequestParam("name") String userName) {
        List<Customer> customers = customerRepository.findByUserName(userName);
        return customers;
    }

    @RequestMapping("/finduser")
    public Customer findUser(@RequestParam("staffid") Long staffId, @RequestParam("name") String userName) {
        return customerRepository.findByStaffIdAndUserName(staffId, userName);
    }

    @RequestMapping("/finduserid")
    public Customer findUser(@RequestParam("staffid") Long staffId) {
        return customerRepository.findByStaffId(staffId);
    }
}
