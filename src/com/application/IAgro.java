package com.application;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.entities.Actividad;
import com.entities.Base;
import com.entities.Casilla;
import com.entities.Formulario;
import com.entities.Rol;
import com.entities.Usuario;
import com.presentation.IFrame;
import com.presentation.ListarActividades;
import com.presentation.ListarFormularios;
import com.presentation.ListarUsuarios;
import com.presentation.AltaUsuario;
import com.presentation.CrearActividad;
import com.presentation.CrearCasilla;
import com.presentation.CrearFormulario;
import com.presentation.EditarCasillas;
import com.presentation.Login;
import com.presentation.MenuPrincipal;
import com.presentation.ModificarActividad;
import com.remote.ActividadBo;
import com.remote.AuthBo;
import com.remote.CasillaBo;
import com.remote.FormularioBo;
import com.remote.UsuarioBo;
import com.service.IBean;

public class IAgro {
	
	//***********************************************
	// Atributos para el manejo de la capa presentacion
	//***********************************************
	
	private Login login; // login
	private MenuPrincipal principal; // menu principal
	private AltaUsuario altaUsuario; // alta usuario
	private ListarUsuarios listarUsuarios; // listar usuarios
	private CrearFormulario crearFormulario; // crear formulario
	private ListarFormularios listarFormularios; // listar formularios
	private CrearCasilla crearCasilla;
	private CrearActividad crearActividad;
	private ListarActividades listarActividades;
	private ModificarActividad modificarActividad;
	private EditarCasillas editarCasilla;
	
	//***********************************************
	// Atributos para el manejo de la capa negocios
	//***********************************************
	
	private AuthBo auth; // autenticacion de usuarios
	private UsuarioBo usuarioBo; // usuarios
	private FormularioBo formularioBo;
	private CasillaBo casillaBo;
	private ActividadBo actividadBo;

	//***********************************************
	// Listados ultra pesados con todos los datos para que la busqueda sea rapida
	//***********************************************
	
	private List<Usuario> usuarios; // listado de usuarios del sistema
	private List<Rol> roles; // listado de roles del sistema
	private List<Formulario> formularios; //listado de formularios del sistema
	private List<Casilla> casillas; //listado de casillas del sistema
	private List<Actividad> actividades;// listado de actividades del sistema

	/**
	 * 
	 * Main IAgro donde todo comienza...
	 * @param args
	 */
	public static void main(String[] args) {
		IAgro iagro = new IAgro(); // Se crea una instancia
		iagro.start();
	}
	
	/**
	 * 
	 * Constructor de IAgro con la UI inicial de login sin mostrarla
	 */
	public IAgro() {
		login = new Login(this); // Inyecto esta instancia a login
	}
	
	/**
	 * 
	 * Metodo para arrancar IAgro con la capa de negocios inicial y mostrando login
	 */
	private void start() {
		auth = new AuthBo();
		usuarioBo = new UsuarioBo();
		formularioBo = new FormularioBo();
		casillaBo = new CasillaBo();
		actividadBo = new ActividadBo();
		refresh(Usuario.class);
		if(usuarios.size() < 1) bootstrap();
		login.start(); // muestro la ventana de login con al menos 1 usuario por defecto cargado en la BD
	}
	
	//***********************************************
	// Metodos para el manejo de la capa presentacion
	//***********************************************
	
	public void menuPrincipal() {
		refresh(Actividad.class);
		refresh(Formulario.class);
		refresh(Casilla.class);
		if(casillas.size() < 1) createDefault();
		principal = new MenuPrincipal(this);
		principal.start();
	}

	/**
	 * 
	 * Metodo para iniciar un frame sin objeto pre cargado
	 * @param c
	 */
	public void show(Class c) {
		IFrame frame = getFrame(c);
		frame.start();
	}
	
	/**
	 * 
	 * Metodo para iniciar un frame con objeto pre cargado
	 * @param c
	 * @param o
	 */
	public void show(Class c, Object o) {
		IFrame frame = getFrame(c);
		frame.setFields(o);
		frame.start();
	}
	
	private IFrame getFrame(Class c) {
		if(c.equals(AltaUsuario.class)) {
			altaUsuario = new AltaUsuario(this);
			return altaUsuario;
		}  else if(c.equals(ListarUsuarios.class)) {
			listarUsuarios = new ListarUsuarios(this);
			return listarUsuarios;
		} else if(c.equals(CrearFormulario.class)) {
			crearFormulario = new CrearFormulario(this);
			return crearFormulario;
		} else if(c.equals(ListarFormularios.class)) {
			listarFormularios = new ListarFormularios(this);
			return listarFormularios;
		} else if(c.equals(CrearCasilla.class)) {
			crearCasilla = new CrearCasilla(this);
			return crearCasilla;
		} else if(c.equals(CrearActividad.class)) {
			crearActividad = new CrearActividad(this);
			return crearActividad;
		} else if(c.equals(ListarActividades.class)) {
			listarActividades = new ListarActividades(this);
			return listarActividades;
		} else if(c.equals(ModificarActividad.class)) {
			modificarActividad = new ModificarActividad(this);
			return modificarActividad;
		} else if(c.equals(EditarCasillas.class)) {
			editarCasilla = new EditarCasillas(this);
			return editarCasilla;
		}		
		return null;
	}
	public String [] getColumnas(){
		String [] columnas = {"ID","NOMBRE","APELLIDO","DOCUMENTO","CLAVE","NICKNAME","EMAIL","ROL"};
		return columnas;
	}
	
//	public String[] getColumnasRoles() {
//		String[] columnas = {"NOMBRE","DESCRIPCION"};
//		return columnas;
//	}
	
	public String [] getColumnasFormulario() {
		String [] columnas = {"ID","NOMBRE"};
		return columnas;
	}
	
	public String [] getColumnasActividad() {
		String [] columnas = {"CREADOR","FECHA / HORA"};
		return columnas;
	}
	
	
	//**********************************************
	// Metodos para el manejo de la capa de negocios
	//**********************************************
	
	public void login(String username, String password) {
		auth.login(username, password);
	}
	
	public void logout() {
		auth.logout();
		login.limpiar();
		login.start();
	}
	
	public void bootstrap() {
		auth.bootstrap();
		refresh(Usuario.class);
		login.mensajeEditarAdminPassword();
	}
	
	private void createDefault() {
		casillaBo.createDefault();
		refresh(Casilla.class);
	}
	
	public boolean create(Object o) {
		IBean bean = getBean(o.getClass());
		boolean result =  bean.create(o);
		if(result) refresh(o.getClass());
		return result;
	}
	
	public Base read(Long id, Class c) {
		IBean bean = getBean(c);
		return (Base)bean.read(id);
	}
	
	public boolean update(Object o) {
		IBean bean = getBean(o.getClass());
		boolean result =  bean.update(o);
		if(result) refresh(o.getClass());
		return result;
	}
	
	public boolean delete(Long id, Class c) {
		IBean bean = getBean(c);
		boolean result =  bean.delete(id);
		if(result) refresh(c);
		return result;
	}
	
	private void refresh(Class c) {
		IBean bean = getBean(c);
		if(c.equals(Usuario.class)) {
			usuarios = bean.readAll();
		} else if(c.equals(Formulario.class)) {
			formularios = bean.readAll();
		} else if(c.equals(Casilla.class)) {
			casillas = bean.readAll();
		} else if(c.equals(Actividad.class)) {
			actividades = bean.readAll();
		} 
	}
	
	private IBean getBean(Class c) {
		if(c.equals(Usuario.class)) {
			return usuarioBo;
		} else if(c.equals(Formulario.class)) {
			return formularioBo;
		} else if(c.equals(Casilla.class)) {
			return casillaBo;
		} else if(c.equals(Actividad.class)) {
			return actividadBo;
		}
		return null;
	}
	
	public Usuario getAuthUser() {
		return auth.getAuthUser();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Rol> getRoles() {
		return roles;
	}
	
	public List<Formulario> getFormulario(){
		return formularios;
	}
	
	public List<Casilla> getCasillas(){
		return casillas;
	}
	
	public List<Actividad> getActividades(){
		return actividades;
	}
	
	public List<Actividad> getActividadesByForm(Formulario form){
		return actividadBo.readAllByForm(form.getId());
	}
	
	public Actividad getActividadById(Actividad actividad){
		return actividadBo.readOneAndCasillasEInfo(actividad.getId());
	}
	
	// metodos read para cuando NO es por ID
	public Usuario readUsuario(String nickname) {
		Usuario usuario = usuarios.stream()
				.filter(u -> u.getNickname().toString().equals(nickname))
				.collect(Collectors.toList())
				.get(0);
		return usuario;
	}
	
	public Formulario readFormulario(String nombre) {
		Formulario formul = formularios.stream()
				.filter(f -> f.getNombre().equals(nombre))
				.collect(Collectors.toList())
				.get(0);
		
		return formul;
	}
	
	public Casilla readCasilla(String parametro) {
		Casilla casilla = casillas.stream()
				.filter(f -> f.getParametro().equals(parametro))
				.collect(Collectors.toList())
				.get(0);
		
		return casilla;
	}
	
	public Actividad readActividad(String parametro) {
		Actividad actividad = actividades.stream()
				.filter(f -> f.getUsuario().getNickname().equals(parametro))
				.collect(Collectors.toList())
				.get(0);
		
		return actividad;
	}
	
	
	// matrices de datos para los JTable de los listados
	public Object[][] matrixUsuarios() {
		Object[][] datos = new Object[usuarios.size()][getColumnas().length];
		for (Usuario usuario : usuarios) {
			datos[(usuarios.indexOf(usuario))][0] = usuario.getId();
			datos[(usuarios.indexOf(usuario))][1] = usuario.getNombre();
			datos[(usuarios.indexOf(usuario))][2] = usuario.getApellido();
			datos[(usuarios.indexOf(usuario))][3] = usuario.getDocumento();
			datos[(usuarios.indexOf(usuario))][4] = usuario.getClave();
			datos[(usuarios.indexOf(usuario))][5] = usuario.getNickname();
			datos[(usuarios.indexOf(usuario))][6] = usuario.getEmail();
			datos[(usuarios.indexOf(usuario))][7] = usuario.getRol().getRol().name();
		}
		return datos;
	}
	
	public Object[][] matrixFormularios(){
		Object[][] datos = new Object[formularios.size()][getColumnasFormulario().length];
		for (Formulario form : formularios) {
			datos[(formularios.indexOf(form))][0] = form.getId();
			datos[(formularios.indexOf(form))][1] = form.getNombre();
//			datos[(formularios.indexOf(form))][2] = form.getCasillas().size();

		}
		return datos;
	}
	
	public Object[][] matrixActividades(List<Actividad> actividadesFormulario){
		Object[][] datos = new Object[actividadesFormulario.size()][getColumnasActividad().length];
		for (Actividad acti : actividadesFormulario) {
			
			datos[(actividadesFormulario.indexOf(acti))][0] = acti.getUsuario().getNickname();
			
			LocalDateTime fechaHora = acti.getFechaHora();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm:ss");
			String formatDateTime = fechaHora.format(formatter);
			
			datos[(actividadesFormulario.indexOf(acti))][1] = formatDateTime;
			

		}
		return datos;
	} 

}
