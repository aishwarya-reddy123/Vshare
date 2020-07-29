package demo.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import demo.com.repository.PortfolioRepository;
import demo.com.repository.UserRepository;
import demo.com.exception.ResourceNotFoundException;

import demo.com.model.Portfolio;
import demo.com.model.User;
import demo.com.payload.request.CreatePortfolio;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class PortfolioController {
	@Autowired
	private PortfolioRepository portrepo;
	
	@Autowired
	private UserRepository userrepo; 



	@PostMapping("/portfolio")
	public ResponseEntity<Portfolio> getPortfolioById(@RequestBody Long userID)
	{
		Portfolio portfolio = portrepo.findByUserId(userID);
		return new ResponseEntity<Portfolio>(portfolio,HttpStatus.OK);
	}

	@PostMapping("/portfolio/create")
	public Portfolio createPortfolio(@Valid @RequestBody CreatePortfolio portfolio) {
		User user=userrepo.getByID(portfolio.getUser_id());
		Portfolio port=new Portfolio();
		port.setUser(user);
		port.setCurrentvalue(portfolio.getCurrentvalue());
		port.setEquitybalance(portfolio.getEquitybalance());
		port.setInvestmentvalue(portfolio.getInvestmentvalue());
		port.setProfitorloss(portfolio.getProfitorloss());
		return portrepo.save(port);
	}
         
	@PutMapping("/portfolio/{id}")
	public ResponseEntity<Portfolio> updatePortfolio(@PathVariable (value = "user_id") Long userId,@PathVariable(value = "id") Long portfolioId,
			@Valid @RequestBody Portfolio portDetails) throws ResourceNotFoundException {
		Portfolio portfolio = portrepo.findById(portfolioId)
				.orElseThrow(() -> new ResourceNotFoundException("portfolio not found for this id :: " + portfolioId));
		
		portfolio.setCurrentvalue(portDetails.getCurrentvalue());
		portfolio.setInvestmentvalue(portDetails.getInvestmentvalue());
		portfolio.setProfitorloss(portDetails.getProfitorloss());
		portfolio.setEquitybalance(portDetails.getEquitybalance());
		
		final Portfolio updatedPortfolio = portrepo.save(portfolio);
		return ResponseEntity.ok(updatedPortfolio);
	}

	
}
