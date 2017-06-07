package Classes;

/**
 * Created by César on 06/06/2017.
 */

public class Pregunta {
    private int idPregunta;
    private String name;
    private int idTipoPregunta;
    private String respuesta;
    private int pImage;

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(int idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getpImage() {
        return pImage;
    }

    public void setpImage(int pImage) {
        this.pImage = pImage;
    }

    public Pregunta(int idPregunta, String name, int idTipoPregunta, String respuesta, int pImage) {
        this.idPregunta = idPregunta;
        this.name = name;
        this.idTipoPregunta = idTipoPregunta;
        this.respuesta = respuesta;
        this.pImage = pImage;
    }
}
