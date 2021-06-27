package Modelo;

import java.util.Comparator;

public class AsistenciaSortByDoc implements Comparator <Alumno>{

	private double porcentaje;

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public double compare(Alumno o1, Alumno o2) {
		return o1.getPorcentajeAsistencia() - o2.getPorcentajeAsistencia();
	}

}
