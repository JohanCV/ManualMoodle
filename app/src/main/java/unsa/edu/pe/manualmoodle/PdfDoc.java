package unsa.edu.pe.manualmoodle;

public class PdfDoc {
    String name_doc;
    String path_pdf;

    public PdfDoc() {
    }

    public PdfDoc(String path_pdf, String name) {
        this.path_pdf = path_pdf;
        this.name_doc = name;
    }

    public String getName_doc() {
        return name_doc;
    }

    public void setName_doc(String name_doc) {
        this.name_doc = name_doc;
    }

    public String getPath_pdf() {
        return path_pdf;
    }

    public void setPath_pdf(String path_pdf) {
        this.path_pdf = path_pdf;
    }


}
