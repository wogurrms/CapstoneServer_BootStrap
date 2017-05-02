package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.hansung.cse.model.ChartResponseData;
import kr.ac.hansung.cse.service.RecordService;


@RestController
public class RestAPIController {
	@Autowired
	private RecordService recordService; 

	@RequestMapping(value="/chartFromRecordToRest", method=RequestMethod.GET)
	public ResponseEntity<List<ChartResponseData>> chartFromRecordToRest(Model model){
		List<ChartResponseData> chartResponseDataList = recordService.getChartResponseData();

		if(chartResponseDataList.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ChartResponseData>>(chartResponseDataList,HttpStatus.OK);
	}
	
	
	/*
	@Autowired
	private UserService userService;
	
	// ----------------------------- Retrieve All Users -----------------------------
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		// ResponseEntity = header, body(json), HTTP.status �������� �����ؼ� �ѱ� �� ����.
		// JSON format ���� �ٲپ �Ѱ��� ( jackson.databind )
		List<User> users = userService.getUsers();
		if(users.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	// ----------------------------- Retrieve Single User --------------------------
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("userId") int userId){
		User user = userService.getUserById(userId);
		if(user == null ){
			// to do : custom Exception
			throw new UserNotFoundException(id);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	// ----------------------------- Create a User -----------------------------------
	
		@RequestMapping(value="/users", method=RequestMethod.POST)	// Request body(json)�� ������� ������ json �������� �Ѿ��
		public ResponseEntity<Void> createUser(@RequestBody User user, 
				UriComponentsBuilder ucBuilder) {
			// Body �κ��� ���ٴ� �ǹ̷� <Void> �� �־���

			if(userService.isUserExist(user)){
				// to do Exception , User�� �̹� ������ ��� ����
				throw new UserDuplicatedException(user.getName());
			}
			userService.addUser(user);
			
			// header �� ������� uri �� �Ѱ���
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/users/{id}").
					buildAndExpand(user.getUid()).toUri());
			return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		}
		

	// ----------------------------- Update a User --------------------------
		
		@RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
		public ResponseEntity<User> udpateUser(@PathVariable("userId") int userId, @RequestBody User user){
			User currentUser = userService.getUserById(userId);
			if(currentUser == null ){
				// to do Exception 
				throw new UserNotFoundException(id);
			}
			currentUser.setMac(user.getMac());
			currentUser.setNick(user.getNick());
			currentUser.setTobac(user.getTobac());
			
			userService.editUser(currentUser);
			return new ResponseEntity<User>(currentUser,HttpStatus.OK);
		}
		
	// ----------------------------- Delete a User --------------------------
		
		@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
			
			User user = userService.findById(id);
			if(user == null ){
				// to do Exception 
				throw new UserNotFoundException(id);
			}
			userService.deleteUserById(id);
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
	// ----------------------------- Delete All User --------------------------
		
		@RequestMapping(value="/users", method=RequestMethod.DELETE)
		public ResponseEntity<User> deleteAllUsers(){
			
			userService.deleteAllUsers();
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}*/
}
