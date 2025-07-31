package com.example.demo.service;

import com.example.demo.dto.OrdersDTO;
import com.example.demo.model.Orders;
import com.example.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<OrdersDTO> getAllOrders() {
        return ordersRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public OrdersDTO getOrderById(int id) {
        return ordersRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public OrdersDTO saveOrder(Orders order) {
        return convertToDto(ordersRepository.save(order));
    }

    public OrdersDTO updateOrder(int id, Orders updated) {
        return ordersRepository.findById(id)
                .map(existing -> {
                    existing.setCustomerId(updated.getCustomerId());
                    existing.setProductId(updated.getProductId());
                    existing.setQuantity(updated.getQuantity());
                    existing.setOrderDate(updated.getOrderDate());
                    existing.setTotalAmount(updated.getTotalAmount());
                    existing.setStatus(updated.getStatus());
                    return convertToDto(ordersRepository.save(existing));
                })
                .orElse(null);
    }

    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }

    private OrdersDTO convertToDto(Orders order) {
        OrdersDTO dto = new OrdersDTO();
        dto.setOrderId(order.getOrderId());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        return dto;
    }
}
