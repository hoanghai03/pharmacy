package io.hoanghai.pharmacy.repository;

import io.hoanghai.pharmacy.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("orderStatusRepository")
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
    OrderStatus findByName(String name);
}
