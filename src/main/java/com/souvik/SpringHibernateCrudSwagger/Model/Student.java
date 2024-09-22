package com.souvik.SpringHibernateCrudSwagger.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "student")
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(generator = "studseq", strategy = GenerationType.AUTO)
    @SequenceGenerator(sequenceName = "studseq", name = "studseq", allocationSize = 1, initialValue = 1 )
	@Column(name="sid")
	@JsonProperty(value = "sid")
	@NotNull(message = "Id is must")
	private Long sid;
	
	@Column(name="sname",  nullable = false, length = 10)
	@JsonProperty(value = "sname")
	@NotNull(message = "Name should be provided")
	private String sname;
	
	@JsonProperty(value = "sage")
	@Column(name="sage", nullable = false, length = 3)
	@NotNull(message = "Age is must")
	@Min(value = 1, message = "Age cannot be less than 1")
	@Max(value = 100, message = "Age cannot be greater than 100, you are not superhuman")
	private Integer sage;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}


}
