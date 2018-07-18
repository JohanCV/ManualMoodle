package unsa.edu.pe.manualmoodle;

public class PdfDoc {
    String name_doc;
    String path;
    int imagen;

    public PdfDoc() {
    }

    public PdfDoc(int img, String name_doc, String path) {
        this.imagen = img;
        this.name_doc = name_doc;
        this.path = path;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getName_doc() {
        return name_doc;
    }

    public void setName_doc(String name_doc) {
        this.name_doc = name_doc;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
