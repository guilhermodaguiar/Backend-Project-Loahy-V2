package nl.novi.loahy.service;


import nl.novi.loahy.dtos.OrderDto;
import nl.novi.loahy.dtos.OrderInputDto;
import nl.novi.loahy.exeptions.OrderNotFoundException;
import nl.novi.loahy.models.Order;
import nl.novi.loahy.models.Product;
import nl.novi.loahy.repository.OrderRepository;
import nl.novi.loahy.repository.ProductRepository;
import nl.novi.loahy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;
    private final UserService userService;

    private final ProductRepository productRepository;
    private final ProductService productService;


    public OrderService(OrderRepository orderRepository, UserRepository userRepository, UserService userService, ProductRepository productRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return transferOrderListToDto(orderList);
    }

    public OrderDto getOrderById(Integer orderId) {
        if (orderRepository.findById(orderId).isPresent()){
            Order or = orderRepository.findById(orderId).get();
            OrderDto orderDto =transferToDto(or);
            if(or.getUser() != null){
                orderDto.setUserDto(userService.transferToDto(or.getUser()));
            }
            if(or.getProducts() != null){
              orderDto.setProductDto(productService.transferToDto((Product) or.getProducts()));
            }
            return transferToDto(or);
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }
    
    
    public List<OrderDto> transferOrderListToDto(List<Order> orders){
        List<OrderDto> orderDtoList = new ArrayList<>();

        for(Order or : orders) {
            OrderDto orderDto = transferToDto(or);
            if(or.getUser() != null){
                orderDto.setUserDto(userService.transferToDto(or.getUser()));
            }
            if(or.getProducts() != null){
              orderDto.setProductDto(productService.transferToDto((Product) or.getProducts()));
            }
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
    
    public OrderDto addOrder(OrderInputDto orderInputDto) {
        Order or = transferToOrder(orderInputDto);
        orderRepository.save(or);
        
        return transferToDto(or);
    }
    
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }


    public OrderDto fromOrder(Order order) {

        OrderDto orderDto = new OrderDto();

        orderDto.setOrderId(order.getOrderId());
        orderDto.setOrderDate(order.getOrderDate());

        return orderDto;
    }

    public OrderDto updateOrder(Integer orderId, OrderInputDto orderInputDto) {
        if (orderRepository.findById(orderId).isPresent()){

            Order order = orderRepository.findById(orderId).get();

            Order order1 = transferToOrder(orderInputDto);
            order1.setOrderId(order.getOrderId());

            orderRepository.save(order1);

            return transferToDto(order1);

        } else {

            throw new  OrderNotFoundException(orderId);
        }
    }

    public OrderDto transferToDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setOrderId(order.getOrderId());

        return orderDto;
    }


    public Order transferToOrder(OrderInputDto orderInputDto) {
        var order = new Order();
        
        order.setOrderDate(orderInputDto.getOrderDate());

        return order;
    }


    public void assignUserToOrder(Integer orderId, String userEmail) {
        var optionalOrder = orderRepository.findById(orderId);
        var optionalUser = userRepository.findById(userEmail);

        if(optionalOrder.isPresent() && optionalUser.isPresent()) {
            var order = optionalOrder.get();
            var user = optionalUser.get();

            order.setUser(user);
            orderRepository.save(order);
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }


    public void assignProductToOrder(Integer orderId, Integer productId) {
        var optionalOrder = orderRepository.findById(orderId);
        var optionalProduct = productRepository.findById(productId);

        if(optionalOrder.isPresent() && optionalProduct.isPresent()) {
            var order = optionalOrder.get();
            var product = optionalProduct.get();

            order.setProducts((List<Product>) product);
            orderRepository.save(order);
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }

}


