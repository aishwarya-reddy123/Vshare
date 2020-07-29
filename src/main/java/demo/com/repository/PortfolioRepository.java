package demo.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.com.model.Portfolio;

@Repository
public interface PortfolioRepository  extends JpaRepository<Portfolio, Long> {
	
	@Query(value="select * from portfolio where user_id=:id",nativeQuery=true)
	public Portfolio findByUserId(@Param("id")Long userID);
	
	
}
