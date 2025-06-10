package compensationex.domain;

import compensationex.domain.*;
import compensationex.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private Long stock;

    public StockDecreased(Inventory aggregate) {
        super(aggregate);
    }

    public StockDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
