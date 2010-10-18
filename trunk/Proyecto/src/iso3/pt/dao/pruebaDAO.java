package iso3.pt.dao;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class pruebaDAO 
{
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		ptDAO dao = ptDAO.getInstancia();
		
		Map<Integer, Asignatura> cache = dao.getCache();
		
		//Prueba de la cache
		System.out.println("Prueba de la Cache");
		Iterator it = cache.entrySet().iterator();
		while(it.hasNext()) 
		{
			Map.Entry ent = (Map.Entry)it.next();
			Asignatura asig = (Asignatura)ent.getValue();
			System.out.println("Datos basicos de la Asignatura");
			System.out.println("        " + asig.toString());
			Profesor prof = asig.getProfesor();
			System.out.println("        Datos del profesor       " + prof.toString() );
			Set<Alumno> alumnos = asig.getAlumnos();
			System.out.println("        Datos de los alumnos");
			for(Alumno al:alumnos)
			{
				System.out.println("               " + al.toString());
			}
			Set<Unidad> unidades = asig.getUnidades();
			System.out.println("        Datos de las unidades");
			for(Unidad uni:unidades)
			{
				System.out.println("               " + uni.toString());
			}
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Prueba de getProfesor");
		Profesor profe = dao.getProfesor(1);
		System.out.println(" 	Datos basicos del profesor: " + profe.toString());	
		System.out.println();
		System.out.println();
		
		System.out.println("Prueba de getAlumnos");
		Set<Alumno> alumnos = dao.getAlumnos(1);
		System.out.println("     Datos de los alumnos de una asignatura");
		for(Alumno al:alumnos)
		{
			System.out.println("        " + al.toString());
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Prueba de getEvaluacionesOrderBy");
		Set<Evaluacion> evaluaciones = dao.getEvaluacionesOrderedByAsignatura(33333333);
		System.out.println("   Datos de las evaluaciones");
		for(Evaluacion ev:evaluaciones)
		{
			System.out.println("        " + ev.toString());
		}
		System.out.println();
		System.out.println();
		
		
		System.out.println("Prueba de getEvaluaciones");
		Set<Evaluacion> evs = dao.getEvaluaciones(1,33333333);
		System.out.println("     Datos de los alumnos de una evaluacion");
		for(Evaluacion ev:evs)
		{
			System.out.println("        " + ev.toString());
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Prueba de addEvaluacion");
		dao.addEvaluacion("evaluacion 3", (float) 7.0, 1, 33333333);
		System.out.println();
		System.out.println();
		
		System.out.println("Prueba de getUnidades");
		Set<Unidad> unidades = dao.getUnidades(1);
		System.out.println("     Datos de las unidades");
		for(Unidad uni:unidades)
		{
			System.out.println("         " + uni.toString());
		}
		System.out.println();
		System.out.println();
		
		
		System.out.println("Prueba de getAsignaturas");
		Set<Asignatura> asignaturas = dao.getAsignaturas();
		System.out.println("     Datos de las asignaturas");
		for(Asignatura asig:asignaturas)
		{
			System.out.println("         " + asig.toString());
		}
		System.out.println();
		System.out.println();
		
		
		System.out.println("Prueba de getAlumno");
		Alumno alum = dao.getAlumno(33333333);
		System.out.println("     Datos del alumno");
		System.out.println("         " + alum.toString());
		System.out.println();
		System.out.println();
		
		dao.close();
		
		
		/*//Prueba de getProfesor
		System.out.println("Prueba de getProfesor");
		Profesor profesor = dao.getProfesor(1);
		System.out.println(profesor.toString());
		System.out.println();
		System.out.println();
		
		//Prueba de getEvaluaciones
		System.out.println("Prueba de getEvaluaciones");
		Set<Evaluacion> evaluaciones = dao.getEvaluaciones(2, 33333333);
		for(Evaluacion e:evaluaciones)
			System.out.println(e.toString());
		System.out.println();
		System.out.println();
		
		//Prueba de getAlumnos
		System.out.println("Prueba de getAlumnos");
		Set<Alumno> alumnos = dao.getAlumnos(1);
		for(Alumno al:alumnos)
			System.out.println(al.getNombre());*/
		
		
		
	}

}
