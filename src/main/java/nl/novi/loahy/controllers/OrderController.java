package nl.novi.loahy.controllers;


import nl.novi.loahy.dtos.OrderDto;
import nl.novi.loahy.dtos.OrderDtoInput;
import nl.novi.loahy.models.Order;
import nl.novi.loahy.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/all")
    public List<OrderDto> getDeliveryRequests() {

        var dtos = new ArrayList<OrderDto>();
        List<Order> orderList;

        var orders = orderService.getOrders();
        for (Order order : orders) {
            dtos.add(OrderDto.fromOrder(order));
        }
        return dtos;
    }




    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderDtoInput dto){

        return orderService.createOrder(dto);
    }



    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id")Integer id){
        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }


}
