package io.pedrohos.game.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

/**
 * @author pedro-hos
 */
@Entity
public class Cards extends PanacheEntity {
	
	public String answer;
	
	@Transient
	@JsonIncludeProperties("clues")
	public List<Clues> clues;
	
	@Column(name="wikipedia_url", length = 1000)
	public String wikipediaURL;
	
	@Column(name="image_url", length = 1000)
	public String imageURL;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	@JsonIgnoreProperties("cards")
	public Cities city; 
	
	public static Cards randomByStateAndCity(String state, String city, int pageIndex) {
		return find("city.name = ?1 and city.state.name=?2", city, state).page(pageIndex, 1).firstResult();
	}
	
}
