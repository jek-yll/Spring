package org.example.exo1_spring_data_rest.eventHandler;

import org.example.exo1_spring_data_rest.entity.CandiesOrder;
import org.example.exo1_spring_data_rest.entity.OrderStatus;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(CandiesOrder.class)
public class CandiesEventHandler {

    @HandleAfterCreate
    public void handleCandiesOrder(CandiesOrder co){
        if (co.getStatus().equals(OrderStatus.NEW) ){
        System.out.println("Votre commande : " + co + " a bien été créée");
        }
    }
}
