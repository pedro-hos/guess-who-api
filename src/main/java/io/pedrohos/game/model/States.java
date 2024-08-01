package io.pedrohos.game.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

/**
 * @author pedro-hos
 */
@Entity
public class States extends PanacheEntity {
	
	@Column(unique = true)
	public String name;
	public String country;
	
	@OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("state")
	public List<Cities> cities;
	
}
