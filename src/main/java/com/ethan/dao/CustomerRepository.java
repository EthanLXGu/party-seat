package com.ethan.dao;

import com.ethan.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lingxingu on 2017/2/18.
 */

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByUserName(String userName);
//    @Query("select c from Customer c where c.staffId=?1 and c.userName=?2 ")
    Customer findByStaffIdAndUserName(Long staffId, String userName);


//    @Query("select c from Customer c where c.staffId=?1")
    Customer findByStaffId(Long staffId);
}
