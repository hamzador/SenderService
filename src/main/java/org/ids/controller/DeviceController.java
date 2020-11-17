package org.ids.controller;


import java.util.Date;
import java.util.List;

import org.ids.ResouceNotFoundException;
import org.ids.entities.Device;
import org.ids.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class DeviceController {
	
	

	
	@Autowired
	DeviceRepository deviceRepository;

	@PostMapping("/devices")
	public Device addDevice(@RequestBody Device Device) {
		deviceRepository.save(Device);
		return Device;
	}
	
	
	/*@RequestMapping("/temp")
	public Device addTemp() {
		Date date = new Date();
		device temp =new Device("token","nameSensor",10.4,date.toInstant(),1); 
		
		deviceRepository.save(temp);
		return temp;
	}
	
	*/
	
	@GetMapping("/Device/{token}")
    public ResponseEntity<Device> findById(@PathVariable("token") String token){
       Device product = deviceRepository.findById(token).orElseThrow(
                () -> new ResouceNotFoundException("this token not found" + token));
        return ResponseEntity.ok().body(product);
    }
	
	

    @GetMapping("/devices")
    public List<Device> getDevice(){

        return deviceRepository.findAll();
    }
    
    @RequestMapping("/device/find")
    public Device getLast(@RequestParam("deviceToken") String deviceToken) {
    	return deviceRepository.findTopByOrderByTokeDesc(deviceToken);	
    }
    
    @DeleteMapping("temperaturs/{token}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "token") String token) {
        Device device = deviceRepository.findById(token).orElseThrow(
                () -> new ResouceNotFoundException("this token not found::: " + token));
        deviceRepository.delete(device);
        return ResponseEntity.ok().build();
    }
    
 


}
