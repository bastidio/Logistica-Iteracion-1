package Iteracion;


public class Paquete<T> {
	private String id;
	private double peso;
	private String destino;
	private boolean urgente;
	private T contenido;
	private String idHash;

	
	public Paquete(String id, double peso, String destino, boolean urgente, T contenido) {
		if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío.");
        }
        if (destino == null || destino.trim().isEmpty()) {
            throw new IllegalArgumentException("El destino no puede ser nulo o vacío.");
        }
        if (contenido == null) {
            throw new IllegalArgumentException("El contenido no puede ser nulo.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0. Valor ingresado: " + peso);
        }
		
		this.id = id;
		this.peso = peso;
		this.destino = destino;
		this.urgente = urgente;
		this.contenido = contenido;
		this.idHash = generarHash(id);
	}
	

	private String generarHash(String id) {
        return Integer.toHexString(id.hashCode()).toUpperCase();
    }
	
	public String getId() {
		return id;
	}

	public String getIdHash() { return idHash; }
	
	public double getPeso() {
		return peso;
	}

	public String getDestino() {
		return destino;
	}

	public boolean isUrgente() {
		return urgente;
	}

	public T getContenido() {
		return contenido;
	}
}
