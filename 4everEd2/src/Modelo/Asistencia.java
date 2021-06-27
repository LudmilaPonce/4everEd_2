package Modelo;

public class Asistencia implements Comparable <Asistencia>  {

		private Boolean presente;
		private Persona alumno; // agregacion

		public Asistencia(Boolean presente, Alumno alumno) {
			super();
			this.presente = presente;
			this.alumno = alumno;
		}

		public Asistencia() {
			
		}
		public Boolean getPresente() {
			return presente;
		}
		public void setPresente(Boolean presente) {
			this.presente = presente;
		}
		public Persona getAlumno() {
			return alumno;
		}
		public void setAlumno(Persona alumno) {
			this.alumno = alumno;
		}

		@Override
		public int compareTo(Asistencia a) {
			// TODO Auto-generated method stub
			return 0;
		}

}
