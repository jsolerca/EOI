package es.eoi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
		
	@Id
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "NOMBRE")
	private String name;
	
	@Column(name = "DIR")
	private String adress;
	
	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
		
	public Cliente() {
		
	}
	
	public Cliente(String dni, String name, String adress) {
		this.dni = dni;
		this.name = name;
		this.adress = adress;
	}
	
	public Cliente(String dni, String name, String adress, List<Cuenta> cuentas) {
		this.dni = dni;
		this.name = name;
		this.adress = adress;
		this.cuentas = cuentas;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}
