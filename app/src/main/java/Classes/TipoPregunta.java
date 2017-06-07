package Classes;

/**
 * Created by César on 06/06/2017.
 */

public class TipoPregunta {
    private int idTipo;
    private String tipoPregunta;

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public TipoPregunta(int idTipo, String tipoPregunta) {
        this.idTipo = idTipo;
        this.tipoPregunta = tipoPregunta;
    }
}

