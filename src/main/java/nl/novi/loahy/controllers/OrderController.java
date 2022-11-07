
package nl.novi.loahy.controllers;


import nl.novi.loahy.dtos.OrderDto;
import nl.novi.loahy.dtos.OrderInputDto;
import nl.novi.loahy.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();

        return ResponseEntity.ok().body(orderDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id") Integer orderId) {

        OrderDto order = orderService.getOrderById(orderId);

        return ResponseEntity.ok().body(order);
    }


    @PostMapping(value = "create")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderInputDto orderInputDto) {

        OrderDto orderDto = orderService.addOrder(orderInputDto);

        return ResponseEntity.created(null).body(orderDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Integer orderId,
                                                @RequestBody OrderInputDto orderInputDto) {

        OrderDto orderDto = orderService.updateOrder(orderId, orderInputDto);

        return ResponseEntity.ok().body(orderDto);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable("id") Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/{userId}")
    public void assignUserToOrder(@PathVariable("id") Integer orderId, @PathVariable("userId") String userEmail) {
        orderService.assignUserToOrder(orderId, userEmail);
    }

    @PutMapping(value = "/{id}/{productId}")
    public void assignProductToOrder(@PathVariable("id") Integer orderId, @PathVariable("productId") Integer productId) {
        orderService.assignProductToOrder(orderId, productId);
    }

}
