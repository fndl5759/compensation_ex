package compensationex.infra;

import compensationex.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "checkStocks",
    path = "checkStocks"
)
public interface CheckStockRepository
    extends PagingAndSortingRepository<CheckStock, Long> {}
