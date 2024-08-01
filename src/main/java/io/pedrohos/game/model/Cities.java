package io.pedrohos.game.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * @author pedro-hos
 */
@Entity
public class Cities extends PanacheEntity {
	
	public String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "state_id")
	@JsonIgnoreProperties("cities")
	public States state;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("city")
	public List<Cards> cards;
	
}
