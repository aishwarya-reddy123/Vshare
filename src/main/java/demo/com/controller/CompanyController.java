package demo.com.controller;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.com.exception.ResourceNotFoundException;
import demo.com.model.Company;
import demo.com.repository.CompanyRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/stocks")
	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}

	@GetMapping("/stocks/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") Long companyId)
			throws ResourceNotFoundException {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("company not found for this id :: " + companyId));
		return ResponseEntity.ok().body(company);
	}

	@PostMapping("/stocks")
	public Company createCompany(@Valid @RequestBody Company company) {
		return companyRepository.save(company);
	}

	@PutMapping("/stocks/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable(value = "id") Long companyId,
			@Valid @RequestBody Company companyDetails) throws ResourceNotFoundException {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("company not found for this id :: " + companyId));

		company.setName(companyDetails.getName());
		company.setIndex(companyDetails.getIndex());
		company.setMarketcapital(companyDetails.getMarketcapital());
		company.setPrice(companyDetails.getPrice());
		company.setOpen(companyDetails.getOpen());
		company.setClose(companyDetails.getClose());
		company.setHigh(companyDetails.getHigh());
		company.setLow(companyDetails.getLow());
		final Company updatedCompany = companyRepository.save(company);
		return ResponseEntity.ok(updatedCompany);
	}

	@DeleteMapping("/stocks/{id}")
	public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") Long companyId)
			throws ResourceNotFoundException {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("company not found for this id :: " + companyId));

		companyRepository.delete(company);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
