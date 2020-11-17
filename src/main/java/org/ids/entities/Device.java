package org.ids.entities;






import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {

	
	@PrimaryKey
	private String deviceToken ;	
	private Double temperature;
	private Double humidity;
	@CreatedDate
	@JsonProperty(access = Access.READ_ONLY)
	private Long createdAt;
	@JsonProperty(access = Access.READ_ONLY)
	@LastModifiedDate
	private Long updatedAt;
	
	
		

}
