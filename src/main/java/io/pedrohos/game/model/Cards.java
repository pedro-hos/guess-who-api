package io.pedrohos.game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * @author pedro-hos
 */
@Entity
public class Cards extends PanacheEntity {
	
	public String answer;
	
	@Column(name="wikipedia_url")
	public String wikipediaURL;
	
	@Column(name="image_url")
	public String imageURL;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	@JsonIgnoreProperties("cards")
	public Cities city; 
}
