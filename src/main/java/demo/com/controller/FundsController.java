package demo.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.com.model.Funds;
import demo.com.model.User;
import demo.com.payload.request.AddFunds;
import demo.com.payload.response.Response;
import demo.com.repository.FundsRepository;
import demo.com.repository.UserRepository;

@RestController
@RequestMapping("/api/test/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class FundsController {
	@Autowired
	private FundsRepository fundsrepo;
	
	@Autowired
	private UserRepository userrepo; 
	
	@PostMapping("addfunds")
	public ResponseEntity<Response> addFunds(@RequestBody AddFunds addfunds)
	{
		Response resp=new Response();
		User user=userrepo.getByID(addfunds.getUser_id());
		Funds funds=new Funds();
		funds.setAmount(addfunds.getAmount());
		funds.setDate(addfunds.getDate());
		funds.setPayment_id(addfunds.getPayment_Id());
		funds.setUser(user);
		fundsrepo.save(funds);
		resp.setMessage("Successful");
		return new ResponseEntity<Response>(resp,HttpStatus.OK);
	}
	@PostMapping("getfunds")
	public ResponseEntity<Response> getAvailableFunds(@RequestBody Long userId)
	{
		Response response=new Response();
		response.setMessage(String.valueOf(fundsrepo.getAvailableFunds(userId)));
		return new ResponseEntity(response,HttpStatus.OK);
	}

}
