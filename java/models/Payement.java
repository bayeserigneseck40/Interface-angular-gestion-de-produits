package models;
// Generated 15 mai 2022 15:03:36 by Hibernate Tools 3.6.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Payement generated by hbm2java
 */
@Entity
@Table(name = "payement", schema = "public")
public class Payement implements java.io.Serializable {

	private int id;
	private Client client;
	private String modepayement;
	private Integer montant;
	private Set<Service> services = new HashSet<Service>(0);
	private Set<Elementbien> elementbiens = new HashSet<Elementbien>(0);

	public Payement() {
	}

	public Payement(int id, Client client) {
		this.id = id;
		this.client = client;
	}

	public Payement(int id, Client client, String modepayement, Integer montant, Set<Service> services,
			Set<Elementbien> elementbiens) {
		this.id = id;
		this.client = client;
		this.modepayement = modepayement;
		this.montant = montant;
		this.services = services;
		this.elementbiens = elementbiens;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cli_id", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "modepayement", length = 254)
	public String getModepayement() {
		return this.modepayement;
	}

	public void setModepayement(String modepayement) {
		this.modepayement = modepayement;
	}

	@Column(name = "montant")
	public Integer getMontant() {
		return this.montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payement")
	public Set<Service> getServices() {
		return this.services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "association_23", schema = "public", joinColumns = {
			@JoinColumn(name = "pay_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id", nullable = false, updatable = false) })
	public Set<Elementbien> getElementbiens() {
		return this.elementbiens;
	}

	public void setElementbiens(Set<Elementbien> elementbiens) {
		this.elementbiens = elementbiens;
	}

}