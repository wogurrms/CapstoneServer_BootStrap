package kr.ac.hansung.cse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Record {
	@Id
	@GeneratedValue
	@Column(name="record_id")
	private int record_id;
	private String date;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
