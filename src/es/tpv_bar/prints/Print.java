/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.prints;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

/**
 *
 * @author Alberto
 */
public class Print {

    public Print() {
    }

    public Print(String neto, String tara, String bruto, String lote, String cliente, String producto, String codBarras, String caducidad, String envasado) {
        this.neto = neto;
        this.tara = tara;
        this.bruto = bruto;
        this.lote = lote;
        this.cliente = cliente;
        this.producto = producto;
        this.codBarras = codBarras;
        this.caducidad = caducidad;
        this.envasado = envasado;
    }
    int copias;
    String neto;
    String tara;
    String bruto;
    String lote;
    String cliente;
    String producto;
    String codBarras;
    String caducidad;
    String envasado;
    String impresora;
    String etiqueta;

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public String getImpresora() {
        return impresora;
    }

    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }

    public String getBruto() {
        return bruto;
    }

    public void setBruto(String bruto) {
        this.bruto = bruto;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getEnvasado() {
        return envasado;
    }

    public void setEnvasado(String envasado) {
        this.envasado = envasado;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNeto() {
        return neto;
    }

    public void setNeto(String neto) {
        this.neto = neto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void startPrint() {
        try {
            Map parameters = new HashMap();


            parameters.put("NETO", neto);
            parameters.put("TARA", tara);
            parameters.put("BRUTO", bruto);
            parameters.put("LOTE", lote);
            parameters.put("CLIENTE", cliente);
            parameters.put("PRODUCTO", producto);

            JasperPrint print = JasperFillManager.fillReport(etiqueta, parameters,
                    new EtiDataSource());
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals(this.impresora)) {
                    /*If the service is named as what we are querying we select it */
                    selectedService = i;
                }
            }
            System.out.println(services[selectedService]);
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            MediaSizeName mediaSizeName = MediaSize.findMedia(4, 4, MediaPrintableArea.INCH);
            printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(this.copias));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporter.exportReport();
            System.out.println("Fin reporte");
        } catch (PrinterException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private class EtiDataSource implements JRDataSource {

        public EtiDataSource() {
            una = true;
        }
        boolean una = true;

        public boolean next() throws JRException {
            if (una) {
                una = false;
                return true;
            } else {
                return false;
            }
        }

        public Object getFieldValue(JRField jrf) throws JRException {
            Object value = null;

            if ("cliente".equals(jrf.getName())) {
                value = cliente;
            }
            if ("producto".equals(jrf.getName())) {
                value = producto;
            }
            if ("neto".equals(jrf.getName())) {
                value = neto;
            }
            if ("bruto".equals(jrf.getName())) {
                value = bruto;
            }
            if ("tara".equals(jrf.getName())) {
                value = tara;
            }
            if ("lote".equals(jrf.getName())) {
                value = lote;
            }
            if ("codBarras".equals(jrf.getName())) {
                value = codBarras;
            }
            if ("barcode".equals(jrf.getName())) {
                value = codBarras;
            }
            if ("caducidad".equals(jrf.getName())) {
                value = caducidad;
            }
            if ("envasado".equals(jrf.getName())) {
                value = envasado;
            }
            return value;
        }
    }
}
