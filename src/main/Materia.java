package src.main;
/**
 * Classe que representa uma matéria e a sua carga horária total
 * Materia
 */
public class Materia {
    private String nomeMateria;
    private int cargaHorariaTotal;
    /**
     * Método para obter o nome da matéria
     * @return O nome da matéria
     */
    public String getNomeMateria() {
        return nomeMateria;
    }
    /**
     * Método para definir o nome da matéria
     * @param nomeMateria O nome a ser atribuído
     */
    public void setNomeMateria(String nomeMateria){
        this.nomeMateria = nomeMateria;
    }
    /**
     * Método para obter a carga horária total da matéria
     * @return A carga horária total, em horas
     */
    public int getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }
    /**
     * Método para definir a carga horária total da matéria
     * @param cargaHorariaTotal A carga horária a ser atribuída, em horas
     */
    public void setCargaHorariaTotal(int cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }
}
