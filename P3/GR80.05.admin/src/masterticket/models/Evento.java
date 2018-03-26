package masterticket.models;

public class Evento {
	Long id;
	Long idUsuario;
	String titulo;
	String estado;
	String categoria;
	byte[] foto;
	int precioEntrada;
	java.sql.Date fecha;
	String lugar;
	String descripcion;
	int numeroEntradas;
	int numeroEntradasVendidas;
	java.sql.Timestamp created;
	

	public Evento(){
	}
	
	public Evento(Long idUsuario, String titulo, String estado, String categoria, byte[] foto, int precioEntrada, java.sql.Date fecha, String lugar, String descripcion, int numeroEntradas, int numeroEntradasVendidas){
		this.idUsuario   = idUsuario;
		this.titulo = titulo;
		this.estado = estado;
		this.categoria = categoria;
	    this.foto = foto;
		this.precioEntrada = precioEntrada;
		this.fecha = fecha;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.numeroEntradas = numeroEntradas;
		this.numeroEntradasVendidas = numeroEntradasVendidas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public int getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(int precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

	public java.sql.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroEntradas() {
		return numeroEntradas;
	}

	public void setNumeroEntradas(int numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
	}

	public int getNumeroEntradasVendidas() {
		return numeroEntradasVendidas;
	}

	public void setNumeroEntradasVendidas(int numeroEntradasVendidas) {
		this.numeroEntradasVendidas = numeroEntradasVendidas;
	}

	public java.sql.Timestamp getCreated() {
		return created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}
	

}
