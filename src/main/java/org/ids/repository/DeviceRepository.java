package org.ids.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ids.entities.Device;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CassandraRepository<Device,String>{
	
	@Query( "Select * FROM device where deviceToken = :x ORDER BY createdAt DESC LIMIT 1") 
	Device findTopByOrderByTokeDesc(@Param("x") String deviceToken);
	
	
	

}
