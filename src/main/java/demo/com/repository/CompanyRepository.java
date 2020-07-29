package demo.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demo.com.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

	
}
