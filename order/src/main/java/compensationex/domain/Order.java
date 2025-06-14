package compensationex.domain;

import compensationex.domain.OrderPlaced;
import compensationex.domain.OrderCancelled;
import compensationex.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;


@Entity
@Table(name="Order_table")
@Data

//<<< DDD / Aggregate Root
public class Order  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
private Long id;    
    
    
private String productId;    
    
    
private Integer qty;    
    
    
private String customerId;    
    
    
private Double amount;    
    
    
private String status;    
    
    
private String address;
    
    @PostPersist
    public void onPostPersist(){
    // Inventory inventory = OrderApplication.applicationContext
    //     .getBean(compensationex.external.InventoryService.class)
    //     .checkStock(get??);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();



        // OrderCancelled orderCancelled = new OrderCancelled(this);
        // orderCancelled.publishAfterCommit();

    
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




//<<< Clean Arch / Port Method
    public static void updateStatus(OutOfStock outOfStock){
        
        //implement business logic here:
        
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */      

        repository().findById(
            outOfStock.getOrderId()
            ).ifPresent(order->{
            order.setStatus("Order Cancelled");
            repository().save(order);


         });


        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
