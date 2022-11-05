package org.kisan.apis;

import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;

import org.kisan.dto.beans.Test1;
import org.kisan.dto.beans.Test2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestApi {

	private String style1 = "'color:lightgreen;font-size:25px;'";
	
	//@RolesAllowed({"GUEST","ADMIN"})
	@RequestMapping("guest")
	public String guest() {
		
		return "<div style="+style1+">Welcome to secure app- guest page</div>";
	}
	
	@RequestMapping("guest1")
	public String guest1(@PathParam("name") String name) {
		
		return "<div style="+style1+">Welcome to secure app- guest page"+name+"</div>";
	}
	
	@RequestMapping("guest/{name}")
	public String guest2(@PathVariable("name") String name) {
		
		return "<div style="+style1+">Welcome to secure app- guest page"+name+"</div>";
	}
	
	//prePostEnabled=true
	//jsr250Enabled=false(default)
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping("user")
	public String user() {
		
		return "<div style="+style1+">Welcome to secure app- user page</div>";
	}
	
	@RolesAllowed("ADMIN")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("admin")
	public String admin() {
		
		return "<div style="+style1+">Welcome to secure app- admin page</div>";
	}
	
	@RequestMapping("home")
	public String home() {
		
		return "<div style="+style1+">Welcome to secure app- home page</div>";
	}
	
	@RequestMapping(value="test1", method=RequestMethod.POST)
	public ResponseEntity<Test1> testPost1(@RequestBody Test1 test) {
		
		return new ResponseEntity<Test1>(test, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="test2", method=RequestMethod.POST)
	public ResponseEntity<Test2> testPost2(@RequestBody Test2 test) {
		
		return new ResponseEntity<Test2>(test, HttpStatus.CREATED);
	}
}
