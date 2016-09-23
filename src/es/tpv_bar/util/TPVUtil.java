/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.tpv_bar.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author aperalta
 */
public class TPVUtil {
    
    public static Double round(Double d){
        BigDecimal bd = new BigDecimal(d.toString());
        return bd.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
