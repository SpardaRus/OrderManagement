package com.spardarus.controller.order;

import com.spardarus.entity.Order;
import com.spardarus.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {

    public static final String ORDER_MUST_BE_DESC_OR_ASC = "Order must be 'desc' or 'asc'";

    private final OrderRepository orderRepository;

    @GetMapping("/getOrders")
    public ResponseEntity<?> getOrders(@RequestParam(required = false) Integer filter,
                                       @RequestParam(required = false) String sortBy,
                                       @RequestParam(required = false) String order) {
        if (filter != null) {
            return getOrderById(filter);
        }

        if (sortBy != null && order != null) {
            return getSortedOrders(sortBy, order);
        }

        return getAllOrders();
    }

    private ResponseEntity<?> getOrderById(Integer filter) {
        Order order = orderRepository.findById(filter).orElse(null);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> getSortedOrders(String sortBy, String order) {
        try {
            if (order.equals("desc")) {
                return ResponseEntity.ok().body(orderRepository.findAll(Sort.by(sortBy).descending()));
            }
            if (order.equals("asc")) {
                return ResponseEntity.ok().body(orderRepository.findAll(Sort.by(sortBy).ascending()));
            }
        } catch (PropertyReferenceException error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
        return ResponseEntity.badRequest().body(ORDER_MUST_BE_DESC_OR_ASC);
    }

    private ResponseEntity<Iterable<Order>> getAllOrders() {
        Iterable<Order> orders = orderRepository.findAll();
        return orders != null ? ResponseEntity.ok().body(orders) : ResponseEntity.notFound().build();
    }
}
