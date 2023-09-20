package com.project_movie.services;

import com.project_movie.dtos.BookingRequestDTO;
import com.project_movie.entities.Bill;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBillService {
    @Transactional
    void createNewBill(BookingRequestDTO bookingRequestDTO) throws RuntimeException;

    Bill getBillById(Integer id);

    List<Bill> getAllBills();

    void updateBill(Integer id, Bill updatedBill);

    void deleteBill(Integer id);
}
