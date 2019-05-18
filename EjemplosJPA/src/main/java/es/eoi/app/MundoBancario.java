package es.eoi.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.eoi.entity.Cliente;
import es.eoi.entity.Cuenta;
import es.eoi.entity.Sucursal;

public class MundoBancario {

	private static EntityManager em;

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.
				createEntityManagerFactory("EJERCICIOPU");
		em = emf.createEntityManager();
		
		
		
//		createCliente("53242925H", "Javier Soler Cano", "Calle 1");
//		createCliente("51555925H", "Alejandro Martín Martí", "Calle 2");
//		createCliente("53922323H", "Martín Gascón Serrano", "Calle 3");
//		
//		createBanco("ING DIRECT", "ALICANTE");
//		createBanco("BBVA", "MADRID");
//		createBanco("BARCLAYS", "BARCELONA");
		
		Cliente c1 = getCliente("53242925H");
//		System.out.println(c1.getName());
//		c1.setName("Javier Martinez Cano");
//		modificaCliente(c1);
//		System.out.println(c1.getName());
		
		
//		List<Sucursal>  s1 = findSucursal("ING DIRECT");
		
		List<Sucursal>  sucs = findAllSucursales();
		
		createCuenta(c1, sucs.get(1));
		
		findCuentas("53242925H");
		
//		if(s1 != null && !s1.isEmpty() && c1 != null) {
//			createCuenta(c1, s1.get(0));
//		}

	}

	private static List<Sucursal> findAllSucursales() {
		String hql = "FROM Sucursal";
		Query query = em.createQuery(hql);
		List<Sucursal> result = null;

		try {
			result = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error obteniendo cuenta");
		}
		return result;
	}

	public static void createCliente(String dni, String nombre, String dir) {
		try {
			em.getTransaction().begin();
			Cliente cliente = new Cliente(dni, nombre, dir);
			em.persist(cliente);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.getTransaction().commit();
	}
	
	public static void createBanco(String nombre, String ciudad) {
		try {
			em.getTransaction().begin();
			Sucursal sucursal = new Sucursal(nombre, ciudad);
			em.persist(sucursal);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.getTransaction().commit();
	}
	
	public static void createCuenta(Cliente c, Sucursal s) {
		try {
			em.getTransaction().begin();
			Cuenta cuenta = new Cuenta(c, s);
			em.persist(cuenta);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.getTransaction().commit();
	}
	
	public static Cliente getCliente(String dni) {
		Cliente cli = null;
		try {
			cli = em.find(Cliente.class, dni);
		} catch (Exception e) {
			System.out.println("Error obteniendo cliente");
		}
		return cli;
	}
	
	public static Sucursal getSucursal(int id) {
		Sucursal suc = null;
		try {
			suc = em.find(Sucursal.class, id);
		} catch (Exception e) {
			System.out.println("Error obteniendo sucursal");
		}
		return suc;
	}
	
	public static List<Cliente> findCliente(String nombre) {
		String hql = "FROM Cliente C WHERE C.name = :cliente_nombre";
		Query query = em.createQuery(hql);
		query.setParameter("cliente_nombre",nombre);
		
		List<Cliente> result = null;

		try {
			result = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error obteniendo cliente");
		}
		return result;
	}
	
	public static List<Sucursal> findSucursal(String nombre) {
		String hql = "FROM Sucursal S WHERE S.nombre = :sucursal_nombre";
		Query query = em.createQuery(hql);
		query.setParameter("sucursal_nombre",nombre);
		
		List<Sucursal> result = null;

		try {
			result = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error obteniendo cliente");
		}
		return result;
	}
	
	public static List<Sucursal> findCuentas(String dni) {
		String hql = "FROM Cuenta cu WHERE cu.cliente.dni = :cliente_dni";
		Query query = em.createQuery(hql);
		query.setParameter("cliente_dni",dni);
		
		List<Sucursal> result = null;

		try {
			result = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error obteniendo cuentas");
		}
		return result;
	}
	
	
	
	public static void modificaCliente(Cliente c) {
		try {
			em.getTransaction().begin();
			em.merge(c);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.getTransaction().commit();
	}
	
	public static void modificaSucursal(Sucursal s) {
		try {
			em.getTransaction().begin();
			em.merge(s);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.getTransaction().commit();
	}

}
