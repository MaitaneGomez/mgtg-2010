package iso3.pt.action;

import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.service.PtDaoService;
import iso3.pt.service.PtService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LecturerAction extends ActionSupport 
{
	private Integer idAsignatura;
	private String nomAsignatura;
	private Set<Alumno> alumnos;
	private Set<Asignatura> asignaturas;
	private Asignatura asignatura;
	private Alumno alumno;
	private int dniAlumno;
	private int hiddenIdAsignatura;
	private int hiddenDniAlumno;
	
	public int getHiddenIdAsignatura() 
	{
		return hiddenIdAsignatura;
	}

	public void setHiddenIdAsignatura(int hiddenIdAsignatura) 
	{
		this.hiddenIdAsignatura = hiddenIdAsignatura;
	}

	public int getHiddenDniAlumno() 
	{
		return hiddenDniAlumno;
	}

	public void setHiddenDniAlumno(int hiddenDniAlumno) 
	{
		this.hiddenDniAlumno = hiddenDniAlumno;
	}
	
	

	public int getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(int dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public Asignatura getAsignatura() 
	{
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) 
	{
		this.asignatura = asignatura;
	}

	public Alumno getAlumno() 
	{
		return alumno;
	}

	public void setAlumno(Alumno alumno)
	{
		this.alumno = alumno;
	}

	public String getNomAsignatura() 
	{
		return nomAsignatura;
	}

	public void setNomAsignatura(String nomAsignatura) 
	{
		this.nomAsignatura = nomAsignatura;
	}

	public int getIdAsignatura() 
	{
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) 
	{
		this.idAsignatura = idAsignatura;
	}

	public Set<Alumno> getAlumnos() 
	{
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) 
	{
		this.alumnos = alumnos;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) 
	{
		this.asignaturas = asignaturas;
	}

	public String obtenerListaEstudiantes()
	{
		PtDaoService dao = new PtDaoService();
		alumnos = dao.getAlumnos(idAsignatura);
		return "listadoEstudiantes";
	}
	
	
	public String prepCalificar()
	{
		PtDaoService dao =  new PtDaoService();
		asignatura = dao.getAsignatura(this.idAsignatura);
		alumno = dao.getAlumno(this.dniAlumno);
		this.hiddenDniAlumno=this.dniAlumno;
		this.hiddenIdAsignatura=this.idAsignatura;		
		return "listoParaCalificar";
	}
	
	public String obtenerListaAsignaturas()
	{
		PtDaoService dao = new PtDaoService();
		int id = (Integer)ActionContext.getContext().getSession().get("id");
		this.asignaturas = (Set<Asignatura>) dao.getAsignaturasProfesor(id);
		return "listadoAsignaturas";
	}

}
