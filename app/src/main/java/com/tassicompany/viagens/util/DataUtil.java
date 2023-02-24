package com.tassicompany.viagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String periodoEmTxt(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        //Incrementa a data atual
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiroData = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = formatoBrasileiroData.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBrasileiroData.format(dataVolta.getTime());
        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " +
                dataVolta.get(Calendar.YEAR);
    }
}
