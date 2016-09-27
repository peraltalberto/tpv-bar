/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author aperalta
 */
public class FormatoFecha extends MaskFormatter {

        /** Se construye con el patrón deseado */
        public FormatoFecha() throws ParseException {
            // Las # son cifras y representa "dd/mm/yy hh:mm:ss"
            super("##/##/####");
            formato = new SimpleDateFormat("dd/MM/yyyy");
            formato2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        }

        public FormatoFecha(String mascara, String formato) throws ParseException {
            // Las # son cifras y representa "dd/mm/yy hh:mm:ss"
            super(mascara);
            this.formato = new SimpleDateFormat(formato);
        }
        public FormatoFecha(String horas) throws ParseException {
            // Las # son cifras y representa "dd/mm/yy hh:mm:ss"
            this();
            this.horas = horas;
        }
        /** Una clase adecuada para convertir Date a String y viceversa de forma cómoda. Puedes ver cómo se hace el patrón "dd/MM/yy kk:mm:ss" en la API.
        El patrón que pongamos aquí debe cuadrar correctamente con la máscara que hemos puesto en el constructor */
        private SimpleDateFormat formato;
        private SimpleDateFormat formato2;
        private String horas = " 00:00";
        
        @Override
        public Object stringToValue(String text) throws ParseException {
           
            return formato2.parseObject(text+horas);
        }

       
        @Override
        public String valueToString(Object value) throws ParseException {
            if (value == null)
                value = new Date();
            if (value instanceof Date) {
                return formato.format((Date) value);
            }
            return formato.format(new Date());
        }
        
       
    }
