/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.prints;

import es.tpv_bar.persistencia.modelos.LineaModel;
import es.tpv_bar.persistencia.pojos.Cabezera;
import es.tpv_bar.persistencia.pojos.Ubicacion;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
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

  
    int copias = 1;
   
    String impresora = "";
    String etiqueta;
    Cabezera cabezera;
    Ubicacion ubi;

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

    
    
    
    public Cabezera getCabezera() {
        return cabezera;
    }

    public void setCabezera(Cabezera cabezera) {
        this.cabezera = cabezera;
    }

    public Ubicacion getUbi() {
        return ubi;
    }

    public void setUbi(Ubicacion ubi) {
        this.ubi = ubi;
    }


    
    
    public void abrirCaja() {
        try {
            Map parameters = new HashMap();

            

            JasperPrint print = JasperFillManager.fillReport(etiqueta, parameters,
                    new JRDataSource() {
                        boolean t = true;
                @Override
                public boolean next() throws JRException {
                    if(t){
                        t = false;
                        return true;
                    }else{
                        return t;
                    }
                }

                @Override
                public Object getFieldValue(JRField jrf) throws JRException {
                    return 1;
                }
            } );
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals(this.impresora)) {
                    /*If the service is named as what we are querying we select it */
                    selectedService = i;
                    break;
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
        } catch (PrinterException | JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void startPrint() {
        try {
            Map parameters = new HashMap();

            parameters.put("IdTicket", cabezera.getCod());
            parameters.put("UBICACION",ubi.getIdUbicacion());
            parameters.put("fechaTicket", cabezera.getFecha());
            EtiDataSource recorredor = new EtiDataSource();

            JasperPrint print = JasperFillManager.fillReport(etiqueta, parameters,
                   recorredor );
            PrinterJob job = PrinterJob.getPrinterJob();
            
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals(this.impresora)) {
                    /*If the service is named as what we are querying we select it */
                    selectedService = i;
                    break;
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
        } catch (PrinterException | JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private class EtiDataSource implements JRDataSource {

        public EtiDataSource() {
            iActual = -1;
            lista = lm.getTicket(cabezera.getIdCabezera());
        }
        
        LineaModel lm = new LineaModel();
        ArrayList<Ticket> lista;
        int iActual;
        
        @Override
        public boolean next() throws JRException {
           return ++iActual < lista.size();
        }

        @Override
        public Object getFieldValue(JRField jrf) throws JRException {
            Object value = "";

           System.out.println(jrf.getName());
            if ("nombre".equals(jrf.getName())) {
                System.out.println("Dentro de nombre:"+lista.get(iActual).getProducto());
                
                value = lista.get(iActual).getProducto();
                
            }
            if ("cantidad".equals(jrf.getName())) {
                value = lista.get(iActual).getCantidad();
            }
            if ("precio".equals(jrf.getName())) {
                value = lista.get(iActual).getPrecio();
            }
            if ("importe".equals(jrf.getName())) {
                value = lista.get(iActual).getTotal();
            }
            if(value == null){
                System.out.println("ERROR");
            }
            return value;
        }
    }
}
