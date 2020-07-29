package demo.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.com.model.Funds;

@Repository
public interface FundsRepository extends JpaRepository<Funds, Long> {
	
	@Query(value="select sum(amount) from funds where user_id=:id",nativeQuery=true)
	Double getAvailableFunds(@Param("id") Long id);
}
