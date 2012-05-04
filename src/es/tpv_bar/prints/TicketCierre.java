/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.prints;

import es.tpv_bar.persistencia.modelos.CabezeraModel;
import es.tpv_bar.persistencia.modelos.ConfiguracionModel;
import es.tpv_bar.persistencia.modelos.LineaModel;
import es.tpv_bar.persistencia.pojos.Cabezera;
import es.tpv_bar.persistencia.pojos.Configuracion;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Date;
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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

/**
 *
 * @author Usuario
 */
public class TicketCierre {

    public TicketCierre() {
        this.impresora = conf.getValue("impresora1");
        
    }
    
    
        int copias = 1;
   
    String impresora = "";
    String etiqueta="C:\\tpv\\jaspers\\ticketTotal.jasper";
    ConfiguracionModel conf = new ConfiguracionModel();
    public void startPrint() {
        try {
            Map parameters = new HashMap();
           
            parameters.put("fecha", new Date());
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
            Logger.getLogger(TicketCierre.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private class EtiDataSource implements JRDataSource {

        public EtiDataSource() {
            iActual = -1;
            
           Configuracion cierre = (Configuracion) conf.busquedaDato("clave", "cierre");
           
            lista = cab.getCierreCaja(Integer.parseInt(cierre.getValue()));
        }
        CabezeraModel cab = new CabezeraModel();
       
        ArrayList<Cabezera> lista;
        int iActual;
        
        @Override
        public boolean next() throws JRException {
            System.out.println(iActual+1+"<"+lista.size());
           return ++iActual < lista.size();
        }

        @Override
        public Object getFieldValue(JRField jrf) throws JRException {
            Object value = "";

           System.out.println(jrf.getName());
            if("codigo".equals(jrf.getName())){
                if(lista.get(iActual).getEstado()==3){
                    value = " A -";
                }
                value = value +""+ lista.get(iActual).getCod();
            }
            if("hora".equals(jrf.getName())){
                
                value = lista.get(iActual).getFecha();
            }
            if ("importe".equals(jrf.getName())) {
                
                if(lista.get(iActual).getEstado()==1){
                    value = lista.get(iActual).getTotal();
                }
                if(lista.get(iActual).getEstado()==3){
                    value = -1 * lista.get(iActual).getTotal();
                }
                if(value == null||value.equals("")){
                    value = 0;
                }
                System.out.println(value);
            }
            if(value == null){
                System.out.println("ERROR");
            }
            return value;
        }
    }
    
    
}
