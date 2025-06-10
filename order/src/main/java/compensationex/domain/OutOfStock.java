package compensationex.domain;

import compensationex.domain.*;
import compensationex.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OutOfStock extends AbstractEvent {

    private Long id;
    private Long stock;
    private Long orderId;
}
